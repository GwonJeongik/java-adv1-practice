package thread.sync;

import util.ThreadUtils;

import static util.MyLogger.log;

public class BankAccountV3 implements BankAccount {

    private int balance;

    public BankAccountV3(int initialBalance) {
        this.balance = initialBalance;
    }

    @Override
    public boolean withdraw(int amount) {
        log("거래 시작: " + getClass().getSimpleName());

        // 임계 영역 시작
        synchronized (this) {
            log("[검증 시작] 출금액: " + amount + ", 잔액: " + balance);
            if (balance < amount) {
                log("[검증 실패] 출금액: " + amount + ", 잔액: " + balance);
                return false;
            }

            log("[검증 성공] 출금액: " + amount + ", 잔액: " + balance);
            ThreadUtils.sleep(1000); //출금까지 걸리는 시간으로 가정
            balance = balance - amount;
            log("[출금 완료] 출금액: " + amount + ", 변경 잔액: " + balance);
        }
        // 임계 영역 끝

        log("거래 종료");
        return true;

    }

    @Override
    public synchronized int getBalance() {
        return balance;
    }
}
