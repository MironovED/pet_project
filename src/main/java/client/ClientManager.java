package client;

import org.apache.commons.io.FileUtils;
import org.json.JSONObject;
import dto.Song;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * ClientManager содержит методы по взаимодействию с объектами Song
 * Основной метод - получение json из файла. его чтение и запись в обект Song
 */
public class ClientManager {
    private static List<Song> songList = new ArrayList<>();
    private static String[][] songs;
    private static Logger logger = Logger.getLogger(ClientManager.class.getName());

    public static Song findSong(String nameText) {
        // TODO перевести в стрим
        Song foundSong = null;
        for (Song song : songList) {
            if(song.getTitle().equals(nameText)) {
                foundSong = song;
                return foundSong;
            }
        }
        logger.info("Выбрали из списка песню: " + foundSong.toString());
        return foundSong;
    }

    public static String[][] getSongs() {
        setListSongName();
        return songs;
    }

    // метод поиска файла по названию песни
    public static String getSongFindName(String jo) {
        String songName = "";
        try {
            String jsonStr = FileUtils.readFileToString(new File(jo));
            JSONObject json = new JSONObject(jsonStr);
            songName = json.getString("title");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return songName;
    }

    //метод по изъятию данных из объектов Song и создание двухмерного массива строк
    public static void setListSongName() {
        if (!songList.isEmpty()) {
            songList.clear();
        }
        songList = new Client().getListSong();
        songs = new String[songList.size()][3];
        for (int i = 0; i < songList.size(); i++) {
            songs[i][0] = songList.get(i).getAuthor();
            songs[i][1] = songList.get(i).getTitle();
            songs[i][2] = songList.get(i).getLink();
        }
    }
}
