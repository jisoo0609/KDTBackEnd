package T231122.D3Ex;

import java.io.IOException;
import java.util.Scanner;

/*
    1인치는 2.54 센티미터이다.
    사용자에게 정수를 두개 입력받는다.
    첫번째 정수가 0이라면 두번째 정수는 센티미터이고,
    첫번째 정수가 1이라면 두번째 정수는 인치이다.
    센티미터는 해당 길이의 인치로, 인치는 해당 길이의 센티미터로 소수점 2째 자리까지 출력하여라.
 */
public class H3Control {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 정수 두개 입력받음
        System.out.println("정수 두개를 입력하세요");
        int a = sc.nextInt();
        int b = sc.nextInt();

        if(a == 0) {
           System.out.println(String.format("%.2fcm",(double)b*2.54));
        } else if (a == 1) {
            System.out.println(String.format("%d인치", b));
        }
    }
}
