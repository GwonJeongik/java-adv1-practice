package thread.test;

import static util.MyLogger.*;

public class Test1Main {

    public static void main(String[] args) throws InterruptedException {
        CounterThread thread = new CounterThread();
        thread.start();
    }

    static class CounterThread extends Thread {

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                log("value : " + (i + 1));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }
    }
}
