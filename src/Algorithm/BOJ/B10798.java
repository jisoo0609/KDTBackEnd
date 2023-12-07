package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class B10798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 입력받은 글자 이차원 배열에 넣음
        char[][] chars = new char[5][];

        int max = 0;
        for (int i = 0; i < 5; i++) {
            // 이차원 배열의 행에 한 글자씩 넣음
            chars[i] = br.readLine().toCharArray();
            max = Math.max(chars[i].length , max);
        }

        // 이차원 배열의 행을 바꾸면서 열의 첫번째 글자를 읽어옴
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < 5; j++) {
                if (!(i < chars[j].length)) continue;
                sb.append(chars[j][i]);
            }
        }
        System.out.println(sb);
    }
}
