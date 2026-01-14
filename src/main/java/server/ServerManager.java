package server;

import client.ClientManager;
import org.apache.commons.io.FileUtils;
import org.json.JSONObject;
import dto.Song;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ServerManager {
    private final String path = "src/main/resources/song/";
    private static List<Song> songList = new ArrayList<>();

    public List<Song> getSongList() {
        createListSong();
        return songList;
    }
    public void createListSong() {
        File dir = new File("src/main/resources/song/");
        String[] dirContents = dir.list();

        for (int i = 0; i < dirContents.length; i++) {
            addSongList(path + dirContents[i]);
        }
    }

    // метод удаления файла из локальной БД
    public void removeSong(String name) {
        File dir = new File("src/main/resources/song/");
        String[] dirContents = dir.list();

        for( String content : dirContents) {
            if(ClientManager.getSongFindName(path + content).equals(name)) {
                File rm = new File(path + content);
                rm.delete();
            }
        }
    }

    //метод по добавлению песни с список songList
    public static void addSongList(String jo) {
        try {
            String jsonStr = FileUtils.readFileToString(new File(jo));
            JSONObject json = new JSONObject(jsonStr);
            Song song = new Song(json.getString("Author"), json.getString("title"), json.getString("text"), json.getString("link"));
            songList.add(song);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    //метод по созданию json объекта
    public static JSONObject createJson(String author, String title, String text, String link) {
        JSONObject json = new JSONObject();
        json.put("Author", author);
        json.put("title", title);
        json.put("text", text);
        json.put("link", link);
        return json;
    }
}
