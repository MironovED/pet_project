package client;

import client.ui.BaseFrame;
import dto.Song;

import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Client - создает подключение к серверу и забирает список объектов Song
 */
public class Client implements Runnable{
    private static Socket socket;
    private static List<Song> listSong = new ArrayList<>();

    public List<Song> getListSong() {
        run();
        return listSong;
    }


    @Override
    public void run() {
        try {
            socket = new Socket("127.0.0.1", 4242);
            if (socket.isConnected()) {
                System.out.println("Соединение с сервером установлено на порту " + socket.getPort());
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                if (!listSong.isEmpty()) {
                    listSong.clear();
                }
                listSong = (List<Song>) in.readObject();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
