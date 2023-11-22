package T231121.D2Ex;

import java.io.IOException;
import java.util.Scanner;


public class H3Operators {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        if(n<1 || n>26) {
            throw new IOException("범위 외의 숫자를 입력했습니다");
        }

        System.out.println(String.format("입력한 숫자: %d, ASCII CODE: %c", n, n+64));
    }
}
