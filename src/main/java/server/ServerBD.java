package server;

import dto.Song;

import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Сервер, который служит базой данных для страницы списка песен и детального экрана отдльно взятой песни
 * Сервер отправляет список объектов Song клиенту
 */

public class ServerBD implements Runnable {
    private static ServerSocket server;
    private static Socket clientSocket;
    private static ServerManager serverManager = new ServerManager();
    private static List<Song> listSong = new ArrayList<>();
    private static Logger logger = Logger.getLogger(ServerBD.class.getName());

    @Override
    public void run() {
        try {
            server = new ServerSocket(4242);
            logger.info("Сервер запущен на порту " + server.getLocalPort());
            //метод accept() блокирует приложение до тех пор, пока не поступит запрос, после чего возвращает сокет для взаимодействия с клиентом
            while (true) {
                clientSocket = server.accept();
                if (!listSong.isEmpty()) {
                    listSong.clear();
                }
                serverManager.createOrUpdateListSong();
                listSong = serverManager.getSongList();
                ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
                out.writeObject(listSong);
                out.close();
                logger.info("Сервер передал объекты в количестве " + listSong.size());
                logger.info(listSong.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
