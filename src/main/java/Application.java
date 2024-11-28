import static java.lang.Thread.sleep;

public class Application {

    public static void main(String[] args) throws InterruptedException {
        Runnable server = new AppServer();
        Runnable ui = new AppClient();

        Thread one = new Thread(server);
        Thread two = new Thread(ui);
        one.setName("Поток сервера");
        two.setName("Поток интерфейса");

        one.start();
        sleep(2000);
        two.start();
    }
}
