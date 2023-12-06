package Algorithm.Programmers;
// 두 수의 연산값 비교하기
// https://school.programmers.co.kr/learn/courses/30/lessons/181938

public class S181938 {
    public int solution(int a, int b) {
        String strA = Integer.toString(a);
        String strB = Integer.toString(b);

        int resultInt1 = Integer.parseInt(strA+strB);
        int resultInt2 = 2*a*b;

        return Math.max(resultInt1, resultInt2);
    }
}
