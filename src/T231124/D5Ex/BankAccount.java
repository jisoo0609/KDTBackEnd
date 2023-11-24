package T231124.D5Ex;

import java.io.IOException;

public class BankAccount {
    private int totalAccount; // 총 생성된 계좌 수
    private int totalAmount; // 잔고 총합
    private String accountNumber; // 계좌번호
    private String password; // 비밀번호
    public static int count; // 계좌의 수

    public BankAccount(String accountNumber, String password) throws IOException {
        if (accountNumber.isEmpty() || accountNumber.length() > 8) {
            throw new IOException("잘못된 값을 입력했습니다.");
        }
        this.accountNumber = accountNumber;
        if (password.isEmpty() || accountNumber.length() > 4) {
            throw new IOException("잘못된 값을 입력했습니다.");
        }
        this.password = password;
        count++; // 계좌 한개 생성
    }

    public int getTotalAccount() { // 총 계좌의 숫자
        return totalAccount;
    }
    public int getTotalAmount() { // 전체 계좌들의 잔고
        return totalAmount;
    }

    public void deposit(int depositAmount) {
        totalAmount += depositAmount; // 총 잔고 + 입금액
        System.out.println(String.format("%d원을 입금했습니다.", depositAmount));
        System.out.println(String.format("입금 후 총 잔고는 %s 입니다.", totalAmount));
    }

    public boolean withdraw(int withdrawAmount, String password) {
        if (!password.equals(this.password)) {
            System.out.println("비밀번호가 일치하지 않습니다.");
            return false;
        }
        totalAmount -= withdrawAmount; // 총 잔고 - 출금액
        if (totalAmount < withdrawAmount) {
            System.out.println("잔액이 부족합니다.");
            return false;
        }
        System.out.println(String.format("%d원을 출금했습니다.\n출금 후 잔액은 %d원 입니다.",withdrawAmount,totalAmount));
        return true;
    }
}
