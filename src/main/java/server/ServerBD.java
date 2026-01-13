package server;

import client.ClientManager;
import songrepo.Song;

import java.io.File;
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
    private static ServerManager serverManager = new ServerManager();
    private static List<Song> listSong;

    public void startServer() {
        try {
            server = new ServerSocket(4242);
            System.out.println("Сервер запущен");
            //метод accept() блокирует приложение до тех пор, пока не поступит запрос, после чего возвращает сокет для взаимодействия с клиентом
            while (true) {
                listSong = serverManager.getSongList();
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

    @Override
    public void run() {}
}
