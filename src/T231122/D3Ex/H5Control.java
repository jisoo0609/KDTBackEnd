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
        // base가 원래 1의 자리
        int base = sc.nextInt()%10;
        // 현재 얼마인지를 저장하기 위한 변수
        int now = base;
        // 몇번 반복했는지 count
        int i = 0;
        while (true) {
            // 거듭제곱
            now *= base;
            // 1의 제곱만 남김
            now %= 10;
            // 횟수 증가
            i++;
            // 종료조건 확인
            if (now == base) {
                break;
            }
        }
        System.out.println(String.format("%d번",i));
    }
}
