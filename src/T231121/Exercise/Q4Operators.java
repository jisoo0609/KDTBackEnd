package T231121.Exercise;

import java.util.Scanner;

public class Q4Operators {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(a*a*a > b*b);
    }
}
