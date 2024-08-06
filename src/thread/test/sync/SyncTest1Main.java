package thread.test.sync;

import util.MyLogger;

import static util.MyLogger.*;

public class SyncTest1Main {

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Runnable task = new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    counter.increment();
                }
            }
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        log(counter.getCount());
    }

    static class Counter {

        private int count;

        public synchronized void increment() {
            count++;
        }

        public synchronized int getCount() {
            return count;
        }
    }
}
