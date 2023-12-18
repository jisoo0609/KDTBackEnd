package December.Algorithm.T231206;

import java.util.Stack;

// 괄호 테스트
public class ParTest {
    public static void main(String[] args) {
        // target이 맞는 괄호 조합인지 확인하고 싶다
        String target = "(()((())))";
        Stack<Character> charStack = new Stack<>();
        boolean success = true;
        // 1. target의 각 글자를 확인한다
        for (int i = 0; i < target.length(); i++) {
            char next = target.charAt(i);
            // 2. 여는 괄호를 만나면 push
            if (next == '(') {
                charStack.push(next);
            }
            // 3. 닫는 괄호를 만나면, 상황에 따라 pop을 하는데,
            else {
                // 3-1. stack이 비어있는 경우 정당한 괄호가 아니다
                if (charStack.empty()) {
                    System.out.println("NO");
                    break;
                }
                // 3-2. stack이 비어있지 않으면 pop
                else charStack.pop();
            }
        }
        // 4. 문자열 내부 글자를 다 확인했으면, 스택이 비어있는지가 답이다
        if (charStack.empty() && success) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
