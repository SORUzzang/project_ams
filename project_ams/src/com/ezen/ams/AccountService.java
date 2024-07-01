package com.ezen.ams;

/**
 * 계좌목록 관리
 */
public class AccountService {

    private Account[] accounts;
    private int count;

    public AccountService() {
        accounts = new Account[100];
    }

    public AccountService(int capacity) {
        accounts = new Account[capacity];
    }

    public Account[] getAccounts() {
        return accounts;
    }

    public int getCount() {
        return count;
    }

    // 계좌 생성
    public void addAccount(Account account) {
        accounts[count++] = account;
//        count++;
    }

    // 입금
    public long depositAccount(String accountNum, long money) {
        long balance = 0;
        boolean find = false;
        Account findAccount = findAccount(accountNum);
        if (findAccount != null) {
            balance = findAccount.deposit(money);
            find = true;
        }
        if (!find) {
            balance = -1;
        }
        return balance;
    }

    // 출금
    public long withdrawAccount(String accountNum, long money) {
        long balance = 0;
        boolean find = false;
        Account findAccount = findAccount(accountNum);
        if (findAccount != null) {
            balance = findAccount.withdraw(money);
            find = true;
        }
        if (!find) {
            balance = -1;
        }
        return balance;
    }

    // 계좌 검색
    public Account findAccount(String accountNum) {
        for (int i = 0; i < count; i++) {
            Account account = accounts[i];
            if (account.getAccountNum().equals(accountNum)) {
                return account;
            }
        }
        return null;
    }

    // 계좌 삭제
    public boolean removeAccount(String accountNum) {
        for (int i = 0; i < count; i++) {
//            Account account = accounts[i];
//            String num = account.getAccountNum();
//            boolean same = accounts[i].getAccountNum().equals(accountNum);
            // 삭제하고자 하는 객체일 경우
            if (accounts[i].getAccountNum().equals(accountNum)) {
                for (int j = i; j < count-1; j++) {
                    accounts[j] = accounts[j+1];
                }
                count--;
                return true;
            }
        }
        return false;
    }
}