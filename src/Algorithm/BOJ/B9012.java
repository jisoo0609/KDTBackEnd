package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B9012 {
    // 괄호를 검사하는 메서드를 만듦
    public static boolean isVPS(String line) {
        // 각 글자 중 열린 괄호를 담을 스택을 만듦
        Stack<Character> vpsStack = new Stack<>();
        // 입력받은 문자열의 각 글자를 순회한다
        for (int i = 0; i <line.length(); i++) {
            char next = line.charAt(i);
            // 만약 입력받은 글자가 열린 괄호 ( 라면 스택에 푸시
            if (next == '(') {
                vpsStack.push(next);
                // 아니라면 닫힌 괄호 ) 이다
            } else {
                // 스택이 비었다면 false 반환
                if (vpsStack.isEmpty()) {
                    return false;
                    // 비어있지 않으면 pop
                } else {
                    vpsStack.pop();
                }
            }
        }
        // 순회 종료
        // 스택이 비었는지 확인하고 반환한다
        return vpsStack.isEmpty();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String line = br.readLine();
            if (isVPS(line)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
