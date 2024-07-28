package thread.control.join;

import util.ThreadUtils;

import static util.MyLogger.*;

public class JoinMainV3 {

    public static void main(String[] args) throws InterruptedException {

        log("main start");

        SumTask task1 = new SumTask(1, 50);
        SumTask task2 = new SumTask(51, 100);
        Thread thread1 = new Thread(task1, "thread1");
        Thread thread2 = new Thread(task2, "thread2");

        thread1.start();
        thread2.start();

        // thread1의 작업이 끝날 때까지 무기한 대기
        // 이후 thread2의 작업이 끝날 때까지 무기한 대기
        log("main 스레드 join()");
        thread1.join();
        thread2.join();

        log("task1.result = " + task1.result);
        log("task2.result = " + task2.result);

        int sumAll = task1.result + task2.result;
        log("task1 + task2 = " + sumAll);

        log("main end");


    }

    static class SumTask implements Runnable{

        private int startValue;
        private int endValue;
        int result = 0;

        public SumTask(int startValue, int endValue) {
            this.startValue = startValue;
            this.endValue = endValue;
        }


        @Override
        public void run() {

            log("작업 시작");
            ThreadUtils.sleep(2000);
            int sum = 0;
            for (int i = startValue; i <= endValue; i++) {
                sum += i;
            }
            result = sum;
            log("작업 완료 result = " + result);
        }
    }
}
