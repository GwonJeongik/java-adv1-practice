package thread.sync;

import util.ThreadUtils;

import static util.MyLogger.log;

public class BankAccountV2 implements BankAccount {

    private int balance;

    public BankAccountV2(int initialBalance) {
        this.balance = initialBalance;
    }

    @Override
    public synchronized boolean withdraw(int amount) {
        log("거래 시작: " + getClass().getSimpleName());

        // 잔액보다 출금액이 많으면 검증 실패
        log("[검증 시작] 출금액: " + amount + ", 잔액: " + balance);
        if (balance < amount) {
            log("[검증 실패] 출금액: " + amount + ", 잔액: " + balance);
            return false;
        }

        log("[검증 성공] 출금액: " + amount + ", 잔액: " + balance);
        ThreadUtils.sleep(1000); //출금까지 걸리는 시간으로 가정
        balance = balance - amount;
        log("[출금 완료] 출금액: " + amount + ", 변경 잔액: " + balance);

        log("거래 종료");
        return true;

    }

    @Override
    public synchronized int getBalance() {
        return balance;
    }
}
