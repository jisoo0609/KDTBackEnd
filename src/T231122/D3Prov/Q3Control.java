package T231122.D3Prov;

import java.util.Scanner;

public class Q3Control {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int sum = 0;
        for(int i=0; i<n; i++) {
            sum += sc.nextInt();
        }

        System.out.println("총합: "+sum);
        System.out.println("평균: "+(double)sum/n);
    }
}
