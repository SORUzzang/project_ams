package com.ezen.ams;

public class MinusAccount extends Account {
    private long borrowMoney;

    public MinusAccount(){
        //super();
    }

    public MinusAccount(String accountNum, String accountOwner, int passwd, long balance, long borrowMoney) {
        super(accountNum, accountOwner, passwd, balance);
        this.borrowMoney = borrowMoney;
    }

    public long getBorrowMoney() {
        return borrowMoney;
    }

    public void setBorrowMoney(long borrowMoney) {
        this.borrowMoney = borrowMoney;
    }

    // 재정의가 필요한 메소드
    @Override
    public long getBalance() {
        return super.getBalance() - borrowMoney ;
    }

    @Override
    public void printAll() {
        //super.printAll();
        String allInfo = getAccountNum() + "\t" + getAccountOwner() + "\t" + "****" + "\t" + getBalance() + "\t" + getBorrowMoney();
        System.out.println(allInfo);

    }
}
