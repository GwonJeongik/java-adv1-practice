package thread.control.interrupt;

import static util.MyLogger.log;
import static util.ThreadUtils.*;

public class ThreadStopMainV2 {

    public static void main(String[] args) {

        Thread thread = new Thread(new MyTask(), "work");

        thread.start();

        sleep(4000);
        log("작업 중단 지시 thread.interrupt()");
        thread.interrupt();
        log("work 인터럽트 상태 1 = " + thread.isInterrupted());
    }


    static class MyTask implements Runnable {

        @Override
        public void run() {

            try {
                while (true) {
                    log("작업 중");
                    Thread.sleep(3000);
                }

            } catch (InterruptedException e) {
                log("work 스레드 인터럽트 상태 2 = " + Thread.currentThread().isInterrupted());
                log("interrupted message = " + e.getMessage());
                log("state = " + Thread.currentThread().getState());
            }
            log("자원 정리");
            log("작업 종료");

        }
    }
}
