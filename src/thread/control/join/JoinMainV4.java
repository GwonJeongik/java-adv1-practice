package thread.control.join;

import util.ThreadUtils;

import static util.MyLogger.log;

public class JoinMainV4 {

    public static void main(String[] args) throws InterruptedException {

        log("main start");

        SumTask task1 = new SumTask(1, 50);
        Thread thread1 = new Thread(task1, "thread1");

        thread1.start();

        // thread1의 작업을 1초 동안만 기다림
        log("main 스레드 join(ms)");
        thread1.join(1000);

        log("task1.result = " + task1.result);

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
