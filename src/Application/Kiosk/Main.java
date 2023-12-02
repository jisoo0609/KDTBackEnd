package Application.Kiosk;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        // 1. 키오스크 첫 화면
        System.out.println("환영합니다!");
        while(true) {
            System.out.println("1. 주문하기");
            System.out.println("2. 종료");
            System.out.print("선택하세요: ");
            int select = sc.nextInt();

            if (select == 1){
                break;
            } else if (select == 2) {
                System.out.println("안녕히가세요~");
                break;
                // 프로그램 종료
            }else {
                throw new IOException("잘못된 숫자를 입력하셨습니다. \n 숫자를 다시 입력하세요");
            }
        }

    }
}
