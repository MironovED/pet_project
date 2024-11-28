import server.ServerBD;

public class Application implements Runnable {

    @Override
    public void run() {}

    public static void main(String[] args) {
        Runnable runner =(Runnable) new ServerBD();
        Thread server = new Thread();

    }

}
