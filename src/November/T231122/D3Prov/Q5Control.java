package November.T231122.D3Prov;

import java.util.Scanner;

/* 한 정수를 입력받는다. 이 정수는 잔고이다.
   이후 반복해서 인출할 돈을 정수로 계속 입력받는다.
   인출한 결과를 "성공: 잔고"의 형태로 출력하고,
   잔고가 부족할 경우 "잔고가 부족합니다". 라고 출력 뒤 프로그램을 종료하여라.
 */
public class Q5Control {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int balance = sc.nextInt(); // 잔고

        while (true) {
            int money = sc.nextInt();
            if(money > balance) {
                System.out.println("잔고가 부족합니다");
                break;
            }
            balance -= money;
            System.out.println(String.format("성공: %d",balance));
        }
    }
}
