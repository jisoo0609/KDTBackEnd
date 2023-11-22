package T231122.D3Ex;

import java.util.Scanner;

/*
    한 정수를 입력받는다.
    이후 이 정수를 거듭제곱하며 1의 자리를 확인하면서,
    몇번 거듭제곱 했을 때 다시 원래의 숫자의 1의 자리랑 일치하는지 출력하여라.
 */
public class H5Control {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("정수를 입력하세요: ");
        int n = sc.nextInt();
        int start = n%10;
        System.out.println(start);

        int i = 2;
        while (true) {
            n *= n;
            System.out.println(String.format("n^%d: %d",i,n));
            System.out.println(String.format("1의 자리: %d",n%10));

            if (n%10 == start) {
                System.out.println(String.format("%d번",i));
                break;
            }
            i++;
        }
    }
}
