package com.ezen.ams.bin;

import com.ezen.ams.Account;
import com.ezen.ams.AccountService;
import com.ezen.ams.MinusAccount;

public class AccountApplicationV4 {
    public static void main(String[] args) {
        AccountService accountService = new AccountService(10);

        // 신규계좌 등록
        Account account = new Account("1111-2222", "김기정", 1111, 10000);
        accountService.addAccount(account);
        accountService.addAccount(new Account("1111-3333", "박기정", 1111, 10000));

        MinusAccount minusAccount = new MinusAccount("7777-1111", "김대출", 1111, 1000, 10000);
        accountService.addAccount(minusAccount);
        accountService.addAccount(new MinusAccount("7777-2222", "박대출", 1111, 1000, 10000));
        System.out.println("신규 계좌 등록 완료!!!!");
        // 계좌목록 출력
        Account[] list = accountService.getAccounts();
        for (int i = 0; i < accountService.getCount(); i++) {
            Account acc = list[i];
            acc.printAll();
        }
















    }
}
