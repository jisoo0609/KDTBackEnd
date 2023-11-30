package November.T231121.D2Ex;

import java.util.Scanner;
public class H6Operators {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double temp = sc.nextDouble();

        boolean result = temp >= 38 || temp <=36;
        System.out.println(result);
    }
}
