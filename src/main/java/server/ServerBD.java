package server;

import client.ClientManager;
import songrepo.Song;

import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

/**
 * Сервер, который служит базой данных для страницы списка песен и детального экрана отдльно взятой песни
 * Сервер отправляет список объектов Song клиенту
 */

public class ServerBD implements Runnable {
    private static ServerSocket server;
    private static Socket clientSocket;
    private static ClientManager clientManager = new ClientManager();
    private static List<Song> listSong = clientManager.getSongList();

    public void startServer() {
        try {
            server = new ServerSocket(4242);
            System.out.println("Сервер запущен");
            //метод accept() блокирует приложение до тех пор, пока не поступит запрос, после чего возвращает сокет для взаимодействия с клиентом
            while (true) {
                clientSocket = server.accept();
                ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
                out.writeObject(listSong);
                out.close();
                System.out.println(listSong);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createListSong() {
        clientManager.addSongList("src/main/resources/song/song1.json");
        clientManager.addSongList("src/main/resources/song/song2.json");
        clientManager.addSongList("src/main/resources/song/song3.json");
        clientManager.addSongList("src/main/resources/song/song4.json");
        clientManager.addSongList("src/main/resources/song/song5.json");
        clientManager.addSongList("src/main/resources/song/song6.json");
        clientManager.addSongList("src/main/resources/song/song7.json");
        clientManager.addSongList("src/main/resources/song/song8.json");
        clientManager.addSongList("src/main/resources/song/song9.json");
        clientManager.addSongList("src/main/resources/song/song10.json");
        clientManager.addSongList("src/main/resources/song/song11.json");
        clientManager.addSongList("src/main/resources/song/song12.json");
        clientManager.addSongList("src/main/resources/song/song13.json");
        clientManager.addSongList("src/main/resources/song/song14.json");
        clientManager.addSongList("src/main/resources/song/song15.json");
        clientManager.addSongList("src/main/resources/song/song16.json");
        clientManager.addSongList("src/main/resources/song/song17.json");
        clientManager.addSongList("src/main/resources/song/song18.json");
        clientManager.addSongList("src/main/resources/song/song19.json");
        clientManager.addSongList("src/main/resources/song/song20.json");
        clientManager.addSongList("src/main/resources/song/song21.json");
        clientManager.addSongList("src/main/resources/song/song22.json");
        clientManager.addSongList("src/main/resources/song/song23.json");
        clientManager.addSongList("src/main/resources/song/song24.json");
        clientManager.addSongList("src/main/resources/song/song25.json");
    }

    @Override
    public void run() {}
}
