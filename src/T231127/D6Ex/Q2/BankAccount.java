package T231127.D6Ex.Q2;

public class BankAccount {
    protected int balance; // 현재 잔고
    private int password; // 비밀번호

    public int getBalance() {
        return balance;
    }
    public int getPassword() {
        return password;
    }

    public BankAccount(int password) {
        this.password = password;
        this.balance = 0;
    }


}
