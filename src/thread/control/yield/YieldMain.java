package thread.control.yield;

import static util.ThreadUtils.sleep;

public class YieldMain {

    static class MyRunnable implements Runnable{

        static final int THREAD_COUNT = 1000;

        public static void main(String[] args) {
            for (int i = 0; i < THREAD_COUNT; i++) {
                Thread thread = new Thread(new MyRunnable());
                thread.start();
            }
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " - " + i);
                // 1. empty
                // sleep(1); // 2.sleep(ms)
//                Thread.yield();
            }
        }
    }
}
