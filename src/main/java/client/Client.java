package client;

import client.ui.BaseFrame;
import dto.Song;

import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Client - создает подключение к серверу и забирает список объектов Song
 */
public class Client implements Runnable{
    private static Socket socket;
    private static List<Song> listSong = new ArrayList<>();
    public static Logger logger = Logger.getLogger(Client.class.getName());

    public List<Song> getListSong() {
        run();
        return listSong;
    }


    @Override
    public void run() {
        try {
            socket = new Socket("127.0.0.1", 4242);
            logger.info("Клиент запущен на порту: " + socket.getPort());
            if (socket.isConnected()) {
                logger.info("Соединение с сервером установлено");
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                if (!listSong.isEmpty()) {
                    listSong.clear();
                }
                listSong = (List<Song>) in.readObject();
                logger.info("Клиентом получены объекты в количестве: " + listSong.size());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
