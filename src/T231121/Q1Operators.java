package T231121;/* Q1. 세 과목의 시험점수가 입력될 때,
평균 점수를 구하여라.
 */

import java.util.Scanner;
public class Q1Operators {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        double avg = (double)(a+b+c)/3;
        System.out.println(avg);

        /*
        int[] score = new int[3];
        double sum = 0;
        for(int i=0; i<score.length; i++) {
            score[i] = sc.nextInt();
            sum += score[i];
        }

        double average = sum/score.length;
        System.out.println(average);
        */
    }
}
