package thread.control;

import util.MyLogger;

import static util.MyLogger.*;

public class ThreadStateMain {

    public static void main(String[] args) throws InterruptedException {
        log("==main start==");
        Thread thread = new Thread(new MyRunnable(), "myThread"); //스레드 생성
        log("myThread.state1 = " + thread.getState()); //NEW
        thread.start(); // 스레드 start()
        Thread.sleep(2000); // run 스레드가 자는 상태를 확인하기 위해 main 스레드가 thread의 상태를 확인한다.
        log("thread.state3 = " + thread.getState()); // TIMED_WAITING
        Thread.sleep(3000);
        log("thread.state5 = " + thread.getState()); // TERMINATED
        log("==main end==");


    }


    static class MyRunnable implements Runnable {

        @Override
        public void run() {
            try {
                log("--start--");
                Thread thread = Thread.currentThread(); // 현재 run을 실행하는 스레드 -> myThread
                log("thread.state2 = " + thread.getState()); // RUNNABLE
                log("sleep start");
                Thread.sleep(4000);
                log("sleep end");
                log("thread.state4 = " + thread.getState()); // RUNNABLE
                log("--end--");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


        }
    }
}
