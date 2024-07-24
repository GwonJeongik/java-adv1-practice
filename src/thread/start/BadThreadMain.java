package thread.start;

public class BadThreadMain {

    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getName() + " : main() thread.start");

        HelloThread helloThread = new HelloThread();
        System.out.println(Thread.currentThread().getName() + " : thread.start 호출 전");
        helloThread.run();
        System.out.println(Thread.currentThread().getName() + " : thread.start 호출 후");

        System.out.println(Thread.currentThread().getName() + " : main() end");
    }
}
