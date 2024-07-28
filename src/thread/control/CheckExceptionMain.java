package thread.control;

public class CheckExceptionMain {

    public static void main(String[] args) throws Exception {
        throw new Exception();
    }

    static class CheckedRunnable implements Runnable {

        @Override
        public void run() /*throws Exception*/ {
            /*throw new Exception();*/ // 풀면 예외 발생
        }
    }
}
