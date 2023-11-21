package T231121;

import java.util.Scanner;

public class Q5Operators {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int temperature = sc.nextInt();
        boolean picnic = temperature>20 && temperature<30;
        System.out.println(picnic);
    }
}
