package client;

import org.apache.commons.io.FileUtils;
import songrepo.Song;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.*;

/**
 * ClientManager содержит методы по взаимодействию с объектами Song
 * Основной метод - получение json из файла. его чтение и запись в обект Song
 */
public class ClientManager {
    private static List<Song> songList = new ArrayList<>();
    private static List<String> filePath = new ArrayList<>();


    public List<Song> getSongList() {
        return songList;
    }

    public static List<String> getFilePath() {
        return filePath;
    }

    //метод по добавлению песни с список songList
    public void addSongList(String jo) {
        try {
            String jsonStr = FileUtils.readFileToString(new File(jo));
            JSONObject json = new JSONObject(jsonStr);
            Song song = new Song(json.getString("title"), json.getString("text"), json.getString("link"));
            songList.add(song);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void addFilePath(String path) {
        filePath.add(path);
    }
}
