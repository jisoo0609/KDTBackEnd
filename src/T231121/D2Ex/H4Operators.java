package T231121.D2Ex;

import java.util.Scanner;
public class H4Operators {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        boolean result = a%b == 0;
        System.out.println(result);
    }
}
