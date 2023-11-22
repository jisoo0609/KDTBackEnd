package T231122.D3Ex;

import java.util.Scanner;

/*
    한 정수를 입력받아,
    해당 정수가 음수인지 양수인지 아니면 0인지 출력하는 코드를 작성하여라.
 */
public class H1Control {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        if(n>0) {
            System.out.println(String.format("%d는 양수", n));
        } else if(n==0) {
            System.out.println("0");
        } else {
            System.out.println(String.format("%d는 음수", n));
        }
    }
}
