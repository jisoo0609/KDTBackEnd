package November.T231121.D2Ex;

import java.util.Scanner;
public class H5Operators {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long a = sc.nextInt();

        a *= a; // a^2
        System.out.println("a^2: "+a);
        System.out.println(a%10);

        a *= a; //a^4
        System.out.println("a^4: "+a);
        System.out.println(a%10);

        a *= a; // a^8
        System.out.println("a^8: "+a);
        System.out.println(a%10);

    }
}
