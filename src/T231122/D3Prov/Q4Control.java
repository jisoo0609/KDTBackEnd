package T231122.D3Prov;

import java.util.Scanner;
public class Q4Control {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] name = new String[n];

        for(int i=0; i< name.length; i++) {
            name[i] = sc.next();
        }

        for (int i= 0; i<n; i++) {
            System.out.println(name[n-i-1]);
        }
    }
}
