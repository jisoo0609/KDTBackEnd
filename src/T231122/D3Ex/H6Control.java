package T231122.D3Ex;

import java.io.IOException;
import java.util.Scanner;

/*
    1월 1일의 요일과
    2월 29일의 유무가 정수, 불린으로 주어진다.

    이때 1월 1일의 요일은,
    0 - 월요일, 1 - 화요일, 2 - 수요일, 3 - 목요일, 4 - 금요일, 5 - 토요일, 6 - 일요일

    으로 입력된다.

    각 달의 1일이 무슨 요일인지 1월부터 12월까지 순서대로 출력하는 코드를 작성하시오
 */

public class H6Control {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        String[] week = {"월요일", "화요일", "수요일", "목요일", "금요일", "토요일", "일요일"};
        int[] month = {31,28,31,30,31,30,31,31,30,31,30,31};


        System.out.print("1월 1일의 요일을 입력하세요: ");
        int firstWeek = sc.nextInt();
        if(firstWeek > 6 || firstWeek < 0) {
            throw new IOException("잘못된 값을 입력했습니다.");
        }

        System.out.print("윤년의 유무를 입력하세요(윤년인 경우 1): ");
        int Leep = sc.nextInt();
        boolean isLeep = Leep == 1; // 윤년인 경우 1

        if (isLeep) {
            month[1] = 29;
        }

        for (int i=0; i<month.length; i++) {
            System.out.println(String.format("%d월 1일: %s", i+1, week[firstWeek%7]));
            firstWeek += month[i];
        }
    }
}
