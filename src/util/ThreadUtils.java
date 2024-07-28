package util;

import static util.MyLogger.*;

public abstract class ThreadUtils {

    public static void sleep(long millisecond) {

        try {
            Thread.sleep(millisecond);
        } catch (InterruptedException e) {
            log("인터럽트 발생, " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
