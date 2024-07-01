package com.ezen.ams.bin;

import com.ezen.ams.Account;
import com.ezen.ams.AccountService;

public class AccountApplicationV2 {
    public static void main(String[] args) {
//        AccountService accountService = new AccountService();
        AccountService accountService = new AccountService(10);

        // 신규계좌 등록
        Account account = new Account("1111-2222", "김기정", 1111, 10000);
        accountService.addAccount(account);
        accountService.addAccount(new Account("1111-3333", "박기정", 1111, 10000));
        System.out.println("신규 계좌 등록 완료!!!!");
        
        // 계좌목록 출력
        //accountService.printAccounts();

        // 예금
        String accountNum = "1111-2222";
        long inputMoney = 10000;
        long balance = accountService.depositAccount(accountNum, inputMoney);
        // 정상 입금 처리 시
        if(balance > 0){
            System.out.println("※ 정상 입금 처리되었습니다.");
            System.out.println("- 입금 후 잔액 : " + balance);
        }else{
            System.out.println("※ 입금하고자 하는 계좌가 존재하지 않습니다..");
        }

        // 출금
        long outputMoney = 10000;
       balance = accountService.withdrawAccount(accountNum, outputMoney);
        // 정상 출금 처리 시
        if(balance > 0){
            System.out.println("※ 정상 출금 처리되었습니다.");
            System.out.println("- 출금 후 잔액 : " + balance);
        }else{
            System.out.println("※ 출금하고자 하는 계좌가 존재하지 않습니다..");
        }













    }
}
