package T231121;

import java.util.Scanner;

public class Q2Operators {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int hour = (n+7)%12;

        System.out.println(hour);
    }
}
