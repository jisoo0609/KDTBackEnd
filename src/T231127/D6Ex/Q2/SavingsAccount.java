package T231127.D6Ex.Q2;

public class SavingsAccount extends BankAccount {
    private int depositCount; // 입금 회차
    private int maturityCount; // 만기 회차
    private int depositAmount; // 매 회차 입금액

    public int getDepositCount() {
        return depositCount;
    }

    public int getMaturityCount() {
        return maturityCount;
    }

    public int getDepositAmount() {
        return depositAmount;
    }

    public SavingsAccount(int password) {
        super(password);
        balance = 0;
    }

    public boolean deposit(int depositAmount) {
        if (this.depositAmount == depositAmount) {
            depositCount++;
            balance += depositAmount;
            System.out.println(String.format("%d원을 입금했습니다", depositAmount));
            System.out.println(String.format("현재 잔고는 %d원입니다", balance));
            return true;
        }
        if (depositCount > maturityCount) {
            System.out.println("적금이 만기되었습니다");
            return false;
        }
        System.out.println("입금에 실패했습니다");
        return false;
    }

    public boolean withdraw(int amount, int password) {
        if (password == getPassword() && amount < balance) {
            balance -= amount;
            System.out.println(String.format("%d원을 출금했습니다", amount));
            System.out.println(String.format("현재 잔고는 %d원입니다", balance));
            return true;
        }
        System.out.println("출금에 실패했습니다");
        return false;
   }
}
