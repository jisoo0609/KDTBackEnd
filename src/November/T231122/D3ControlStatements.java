package November.T231122;

import java.util.Scanner;

public class D3ControlStatements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 나이를 입력받고, 나이 20 미만일때 입장불가 출력
        int age = 20; // sc.nextInt() -> 고정값
        if(age < 20) {
            System.out.println("입장불가");
            System.out.println(String.format("%d년 후에 오세요", 20-age));
        }

        int multiple = 10;
        // multiple의 2의 배수면 2의 배수 출력
        if(multiple%2 == 0) {
            System.out.println("2의 배수");
        }

        // multiple의 5의 배수면 5의 배수 출력
        if(multiple%5 == 0) {
            System.out.println("5의 배수");
        }

        // multiple의 10의 배수면 10의 배수 출력
        if(multiple%10 == 0) {
            System.out.println("10의 배수");
        }

        // 몇년인지 입력받음
        int year = sc.nextInt();
        if(year % 4 == 0) {
            if(year % 100 != 0) {
                System.out.println("윤년이다");
            }
        }

        // 2의 배수면 짝수 아니면 홀수
        int number = 10;
        if(number % 2 == 0) {
            System.out.println("짝수");
        } else {
            System.out.println("홀수");
        }

        /* 어떤 학생의 시험점수가 입력 되었을 때,
         *  80점을 넘으면 "Good Job"
         *  못넘으면 "Too Bad
         */
        int score = sc.nextInt();
        if(score > 80) {
            System.out.println("Good Job");
        } else {
            System.out.println("Too Bad");
        }

        int[] numbers = {2, 3, 5, 6, 19, 23};
//        int i = 0;
//        int sum = 0;
//
//        // 총합 및 평균 구하기
//        while (i < 6) {
//            System.out.println(numbers[i]);
//            sum += numbers[i];
//            i++;
//        }
//        System.out.println("총합: "+sum);
//        double avg = ((double)sum/numbers.length);
//        System.out.println("평균: "+ avg);

        // 총합, 최대 평균
        int sum = 0;
        int max = -100;
        for (int i=0; i<numbers.length; i++) {
            sum += numbers[i];
            if(numbers[i] > max) {
                max = numbers[i];
            }
        }
        System.out.println("총합: "+sum);
        System.out.println("최대: "+max);
        System.out.println("평균: "+(double)sum/numbers.length);

        /*
        *
        **
        ***
        ****
        *****
        ******
        */
        for(int i=0; i<=5; i++) {
            for(int j=0; j<=i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // foreach
        String[] fruits = {"apple", "pear", "bananan"};
        for (String name : fruits) {
            System.out.println(name);
        }

        // 반복문 제어
        int wallet = 20000;
        int price = 5000;

        while (true) {
            wallet -= price;
            if(wallet <=0) {
                System.out.println("돈 다 써서 더 못먹음");
                //그만먹자
                break;
            }
            System.out.println(String.format("1인분 먹고 %d 남음", price));
        }

        // numbers 내부에 19가 어디있는지
        // 있다면 그 위치를, 없다면 -1을 출력하도록
        numbers = new int[]{1, 3, 4, 11, 19, 21, 23};
        int target = -1;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 19) {
                target = i;
                // 발견 즉시 반복 종료
                break;
            }
        }
        System.out.println(target);

        // 백신을 맞지 않은 사람만 세기
        boolean[] vaccinated = {true, false, false, false, false, false, false, true, true};
        int groupCount = 0;
        for (boolean vaccine : vaccinated) {
            if (vaccine) {
                System.out.println("백신 맞으면 세지 않아요");
                continue;
            }
            groupCount++;
            // 일정 인원 이상이면 입장불가
            if (groupCount > 5) {
                System.out.println("입장이 불가합니다...");
                break;
            }
        }
    }
}
