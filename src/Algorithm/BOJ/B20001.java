package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B20001 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 고무오리 디버깅 시작
        String line = br.readLine();

        // 총 들어온 문제를 꾸준히 세준다
        int count = 0;

        // 마지막에 "고무오리 디버깅 끝"을 입력 받을때까지 반복한다
        while (true) {
            line = br.readLine();
            // 종료조건
            if (line.equals("고무오리 디버깅 끝")) break;

            // 입력이 "문제"면 count++
            if (line.equals("문제")) {
                count++;
            }
            // 입력이 "고무오리"면 count--
            else if (line.equals("고무오리") && count != 0){
                count--;
            }
            // 단, count == 0이면 count +=2
            else {
                count +=2;
            }
        }

        // 출력
        if (count == 0) {
            System.out.println("고무오리야 사랑해");
        } else {
            System.out.println("힝구");
        }
    }
}
