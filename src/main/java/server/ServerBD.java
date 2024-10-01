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

public class ServerBD {
    private static ServerSocket server;
    private static Socket clientSocket;
    private static ClientManager clientManager = new ClientManager();

    public static void main(String[] args) {
        new ServerBD().startServer();
    }

    public void startServer() {
        try {
            server = new ServerSocket(4242);
            System.out.println("Сервер запущен");
            //метод accept() блокирует приложение до тех пор, пока не поступит запрос,
            // после чего возвращает сокет для взаимодействия с клиентом
            while (true) {
                clientSocket = server.accept();
                ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
                out.writeObject(createListSong());
                out.close();
                System.out.println(createListSong());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Song> createListSong() {
        clientManager.addSongList("src/main/resources/song/song1.json");
        clientManager.addSongList("src/main/resources/song/song2.json");
        clientManager.addSongList("src/main/resources/song/song3.json");
        clientManager.addSongList("src/main/resources/song/song4.json");
        clientManager.addSongList("src/main/resources/song/song5.json");
        return clientManager.getSongList();
    }
}
