import client.ui.BaseFrame;

public class AppClient implements Runnable {

    @Override
    public void run() {
        new BaseFrame().start();
    }
}