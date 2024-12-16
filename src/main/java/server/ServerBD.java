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
    private static ClientManager clientManager = new ClientManager();
    private static List<Song> listSong = clientManager.getSongList();
    String path = "src/main/resources/song/";

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

    // метод берет все файлы из локальной директории о создает список объектов Song
    public void createListSong() {
        File dir = new File("src/main/resources/song/");
        String[] dirContents = dir.list();

        for (int i = 0; i < dirContents.length; i++) {
            ClientManager.addSongList(path + dirContents[i]);
        }
    }

    // метод удаления файла из локальной БД
    public void removeSong(String name) {
        File dir = new File("src/main/resources/song/");
        String[] dirContents = dir.list();

        for( String content : dirContents) {
            if(ClientManager.getSongName(path + content).equals(name)) {
                File rm = new File(path + content);
                rm.delete();
            }
        }
    }

    @Override
    public void run() {}
}
