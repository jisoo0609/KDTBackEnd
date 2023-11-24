package T231123.D4Ex;

import java.util.Scanner;

/*
    현재 오전 7시이다.
    정수 n을 인자로 받아서,
    n 시간 후 12시까지 표기된 시계에서
    시침이 어떤 숫자 위에 있는지를 반환하는 메서드를 작성하시오.
    단, 입력이 0 <= n <= 127 를 벗어나면 -1을 반환하시오.
 */
public class H2Methods {
    public static int time(int n) {
        // 입력 범위 벗어남
        if (n < 0 || n > 127) {
            return -1;
        }
        int now = 7;
        // 몇시간이 지나다
        now += n;
        return now % 12 == 0 ? 12 : now % 12;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(time(sc.nextInt()));
    }
}
