package T231121.D2Ex;

import java.util.Scanner;
/*
        어떤 야구단의 승, 무승부, 패가 입력된다.
        이 야구단의 승률 (승 / (승 + 패))를, 소숫점 세번째 자리 까지, 아래와 같이 출력하여라.
        86승 2무 56패 승률: 0.606
*/
public class H1Operators {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int win = sc.nextInt();
        int draw = sc.nextInt();
        int lose = sc.nextInt();

        double percentage = (double)win /(win+lose);

        System.out.println(String.format("%d승 %d무 %d패 승률: %.3fn", win, draw, lose, percentage));
    }
}
