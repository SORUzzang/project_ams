package com.ezen.ams.bin;

import com.ezen.ams.Account;

import java.util.Scanner;

public class AccountApplication {

    public static void main(String[] args) {

        System.out.println("****************************************");
        System.out.println("*** " + Account.bankName + "은행 계좌 관리 프로그램 ***");
        System.out.println("****************************************");

        boolean running = true;
        Scanner scanner = new Scanner(System.in);

//        Account account = null;
        Account[] accounts = new Account[100];

        // 테스트를 위한 샘플(더미) 데이터 입력
        accounts[0] = new Account("1111-2222", "김기정", 1111, 10000);
        accounts[1] = new Account("1111-3333", "박기정", 1111, 10000);
        accounts[2] = new Account("1111-4444", "송기정", 1111, 10000);
        int count = 3;

        while(running) {
            System.out.println("---------------------------------------------------");
            System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
            System.out.println("---------------------------------------------------");

            System.out.print("선택 > ");
            int menuNum = scanner.nextInt();
            switch (menuNum) {
                case 1 :
                    // 계좌번호 입력받기
                    String accountNum = null;
                    String accountOwner = null;
                    int password = 0;
                    long balance = 0L;
                    System.out.print("계좌번호 : ");
                    accountNum = scanner.next();
                    System.out.print("예금주명 : ");
                    accountOwner = scanner.next();
                    System.out.print("비밀번호 : ");
                    password = scanner.nextInt();
                    System.out.print("초기입금액 : ");
                    balance = scanner.nextLong();

                    // 신규계좌 생성
                    Account account = new Account(accountNum, accountOwner, password, balance);
                    // 생성된 계좌를 배열에 저장
                    accounts[count] = account;
                    count++;

                    System.out.println("※ 신규 계좌("+account.getAccountNum()+")를 등록 하였습니다..");
                    break;
                case 2 : // 전체계좌 목록 조회
                    System.out.println("-----------------------------------------");
                    System.out.println("계좌번호\t예금주명\t비밀번호\t잔액");
                    System.out.println("-----------------------------------------");
                    for (int i = 0; i < count; i++) {
                        String num = accounts[i].getAccountNum();
                        String owner = accounts[i].getAccountOwner();
                        String pass = "****";
                        long money = accounts[i].getBalance();
                        System.out.println(num + "\t" + owner + "\t" + pass + "\t" + money);
                    }
                    break;
                case 3 : // 예금
                    System.out.print("계좌번호 : ");
                    String inputAccountNum = scanner.next();
                    System.out.print("예금액 : ");
                    long inputMoney = scanner.nextLong();

                    boolean find = false;
                    for (int i = 0; i < count; i++) {
                        Account findAccount = accounts[i];
                        String num = findAccount.getAccountNum();
                        // 입력한 계좌번호가 찾아진 계좌의 계좌번호와 같으면
                        if(num.equals(inputAccountNum)){
                            long amount = findAccount.deposit(inputMoney);
                            System.out.println("※ 정상 입금 처리되었습니다.");
                            System.out.println("- 입금 후 잔액 : " + amount);
                            find = true;
                            break;
                        }
                    }
                    if(!find){
                        System.out.println("※ 입금하고자 하는 계좌가 존재하지 않습니다..");
                    }
                    break;
                case 4 : // 출금
                    System.out.print("계좌번호 : ");
                    String outputAccountNum = scanner.next();
                    System.out.print("출금액 : ");
                    long outputMoney = scanner.nextLong();

                    boolean isFind = false;
                    for (int i = 0; i < count; i++) {
                        Account findAccount = accounts[i];
                        String num = findAccount.getAccountNum();
                        // 입력한 계좌번호가 찾아진 계좌의 계좌번호와 같으면
                        if(num.equals(outputAccountNum)){
                            long amount = findAccount.withdraw(outputMoney);
                            System.out.println("※ 정상 출금 처리되었습니다.");
                            System.out.println("- 출금 후 잔액 : " + amount);
                            isFind = true;
                            break;
                        }
                    }
                    if(!isFind){
                        System.out.println("※ 출금하고자 하는 계좌가 존재하지 않습니다..");
                    }
                    break;
                case 5 :
                    System.out.println("프로그램을 종료합니다..");
                    //return;
                    running = false;
                    break;
            }
        }
    }
}
