package T231121.D2Prov;

import java.util.Scanner;

public class Q6Operators {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        boolean result = a%b == 0 && a%c == 0;
        System.out.println(result);
    }
}
