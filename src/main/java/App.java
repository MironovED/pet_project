import client.screens.MainScreen;
import server.ServerBD;

import static java.lang.Thread.sleep;

public class App {

    public static void main(String[] args) {
        try {
            new ServerBD().startServer();
            sleep(5000);
            new MainScreen().start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
