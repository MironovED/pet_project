
import server.ServerBD;

public class AppServer {

    public static void main(String[] args) {
        new ServerBD().createListSong();
        new ServerBD().startServer();
    }
}
