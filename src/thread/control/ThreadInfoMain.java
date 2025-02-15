package thread.control;

import thread.start.HelloThread;
import util.MyLogger;

import static util.MyLogger.*;

public class ThreadInfoMain {

    public static void main(String[] args) {

        Thread mainThread = Thread.currentThread();
        log("mainThread = " + mainThread);
        log("mainThread.threadId() = " + mainThread.threadId());
        log("mainThread.getName()" + mainThread.getName());
        log("mainThread.getPriority() = " + mainThread.getPriority());
        log("mainThread.getThreadGroup() = " + mainThread.getThreadGroup());
        log("mainThread.getState() = " + mainThread.getState());

        System.out.println("=====================================================");

        Thread myThread = new Thread(new HelloThread(), "myThread");
        log("myThread = " + myThread);
        log("myThread.ThreadId() = " + myThread.threadId());
        log("myThread.getName() = " + myThread.getName());
        log("myThread.getPriority() = " + myThread.getPriority());
        log("myThread.getThreadGroup() = " + myThread.getThreadGroup());
        log("myThread.getState() = " + myThread.getState());
    }
}
