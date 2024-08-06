package thread.test.sync;

import static util.MyLogger.log;

public class SyncTest2Main {

    public static void main(String[] args) {
        Counter counter = new Counter();

        Runnable task = new Runnable() {

            @Override
            public void run() {
                counter.count();
            }
        };

        Thread thread1 = new Thread(task); // t1 생성
        Thread thread2 = new Thread(task); // t2 생성

        thread1.start(); // t1 스택영역에 들어가면서 실행 -> t1 localValue 생성 초기화 -> 1000까지 localValue 올림
        thread2.start(); // t2 스택영역에 들어가면서 실행 -> t2 localValue 생성 초기화 -> 1000까지 localValue 올림
        // t1 스레드 | t2 스레드 각각 수행
    }

    static class Counter {

        public void count() {
            int localValue = 0;
            for (int i = 0; i < 1000; i++) {
                localValue++;
            }
            log("결과: " + localValue);
        }
    }
}
