package client;

import songrepo.Song;

import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.List;

/**
 * Client - создает подключение к серверу и забирает список объектов Song
 */
public class Client {
    Socket socket;
    List<Song> listSong;

    public List<Song> getListSong() {
        startClient();
        return listSong;
    }

    public void startClient() {
        try {
            socket = new Socket("127.0.0.1", 4242);
            if (socket.isConnected()) {
                System.out.println("Соединение с сервером установлено на порту " + socket.getPort());
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                listSong = (List<Song>) in.readObject();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Client().startClient();
    }
}
