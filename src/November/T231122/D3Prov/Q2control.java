package November.T231122.D3Prov;

import java.util.Scanner;

public class Q2control {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int score = sc.nextInt();
        if(score >= 90) {
            System.out.println("수");
        } else if(score >= 80) {
            System.out.println("우");
        } else {
            System.out.println("미");
        }
    }
}
