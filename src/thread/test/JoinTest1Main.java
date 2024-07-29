package thread.test;

import static util.MyLogger.*;
import static util.ThreadUtils.*;

public class JoinTest1Main {

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(new MyTask(), "thread1");  //thread1 생성
        Thread thread2 = new Thread(new MyTask(), "thread2");  //thread2 생성
        Thread thread3 = new Thread(new MyTask(), "thread3");  //thread3 생성

        thread1.start();  // 스택 할당  ->  run
        thread1.join();   // thread1 끝날 때까지 대기

        thread2.start();
        thread2.join();

        thread3.start();
        thread3.join();

        System.out.println("모든 스레드 실행 완료");
        // thread1 1, 2, 3
        // thread2 1, 2, 3
        // thread3 1, 2, 3

    }

    static class MyTask implements Runnable{

        @Override
        public void run() {

            for (int i = 1; i <= 3; i++) {
                log(i);
                sleep(1000); // ,스레드 1초 sleep
            }
        }
    }
}
