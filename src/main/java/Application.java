import client.Client;
import client.ui.BaseFrame;
import server.ServerBD;

import static java.lang.Thread.sleep;

public class Application { // TODO при добавлении новой песни не происходит обновления таблицы

    public static void main(String[] args) throws InterruptedException {
        Runnable server = new ServerBD();
        Runnable ui = new Client();

        Thread one = new Thread(server);
        Thread two = new Thread(ui);
        one.setName("Поток сервера");
        two.setName("Поток клиента");

        one.start();
        sleep(2000);
        two.start();
        sleep(2000);
        new BaseFrame().start();
    }
}
