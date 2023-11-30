package November.T231123.D4Ex;

import java.util.Scanner;

/*
    사칙연산을 나타내는 문자(char) (+, -, *, /) 하나와
    두개의 정수를 입력받아, 각 기호에 대응하는 연산의 결과를
    반환하는 메서드를 작성하시오.
    단, 정수 범위에서만 결과를 반환합니다.
 */
public class H3Methods {
    public static int calculate() {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        char op = sc.next().charAt(0);
        int b = sc.nextInt();

        if (op == '+' || op == '-' || op =='*' || op == '/') {
            if (op == '+') {
                return a + b;
            } else if (op == '-') {
               return a-b;
            } else if (op == '*') {
                return a * b;
            } else {
                return a/b;
            }
        } else {
            System.out.println("잘못된 입력입니다");
            return -1;
        }
    }

    public static int cacProv(char op, int a, int b) {
        switch (op) {
            case '+':
                return a+b;
            case '-':
                return a-b;
            case '*':
                return a*b;
            case '/':
                return  a/b;
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(calculate());
    }
}
