
import server.ServerBD;

public class AppServer implements Runnable {

    @Override
    public void run() {
        new ServerBD().createListSong();
        new ServerBD().startServer();
    }
}
