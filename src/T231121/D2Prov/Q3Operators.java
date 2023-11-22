package T231121.D2Prov;

import java.util.Scanner;

public class Q3Operators {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        num += sc.nextInt();
        num -= sc.nextInt();
        num *= sc.nextInt();
        num /= sc.nextInt();

        System.out.println(num);
    }
}
