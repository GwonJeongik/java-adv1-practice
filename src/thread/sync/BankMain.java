package thread.sync;

import util.MyLogger;

import static util.MyLogger.*;
import static util.ThreadUtils.sleep;

public class BankMain {

    public static void main(String[] args) throws InterruptedException {

//        BankAccountV1 account = new BankAccountV1(1000);
        BankAccountV2 account = new BankAccountV2(1000);

        Thread t1 = new Thread(new WithdrawTask(account, 800), "t1");
        Thread t2 = new Thread(new WithdrawTask(account, 800), "t2");
        t1.start();
        t2.start();

        sleep(500); // 검증 끝날 때까지 메인 스레드는 기다림
        log("t1 stage: " + t1.getState());
        log("t2.stage: " + t2.getState());

        t1.join();
        t2.join();
        log("최종 잔액: " + account.getBalance());
    }
}
