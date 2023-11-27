package T231124.D5Ex;

import java.io.IOException;

public class BankAccount {
    private int balance; // 잔고
    private String accountNumber; // 계좌번호
    private String password; // 비밀번호
    private static int accountCount; // 계좌의 수
    private static int totalBalance = 0;

    public static int getAccountCount() {
        return accountCount;
    }

    public static int getTotalBalance() {
        return totalBalance;
    }

    public BankAccount(String accountNumber, String password) {
        if (accountNumber.isEmpty() || accountNumber.length() > 8) {
            System.out.println("잘못된 값을 입력했습니다.");
        }
        this.accountNumber = accountNumber;
        if (password.isEmpty() || accountNumber.length() > 4) {
            System.out.println("잘못된 값을 입력했습니다.");
        }
        this.accountNumber = accountNumber;
        this.password = password;
        this.balance = 0;
        accountCount++; // 계좌 한개 생성
        totalBalance++;
    }

    public int deposit(int amount) {
        this.balance += amount; // 잔고 + 입금액
        totalBalance += amount; // 총 잔고
        System.out.println(String.format("%d원을 입금했습니다.", amount));
        System.out.println(String.format("입금 후 총 잔고는 %s 입니다.", this.balance));
        return this.balance;
    }

    public boolean withdraw(int amount, String password) {
        if (!this.password.equals(password) || this.balance < amount) {
            return false;
        }

        this.balance -= amount; // 총 잔고 - 출금액
        totalBalance -= amount;
        System.out.println(String.format("%d원을 출금했습니다.\n출금 후 잔액은 %d원 입니다.",amount, balance));
        return true;
    }

    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("asdf","1234");
        BankAccount account2 = new BankAccount("qwer", "4567");

        account1.deposit(100);
        account2.deposit(200);
        System.out.println(account1.getAccountCount());
        System.out.println(account2.getAccountCount());

        account1.deposit(300);
        System.out.println(account1.withdraw(300,"1234"));
        System.out.println(account2.withdraw(300,"4567"));
    }
}
