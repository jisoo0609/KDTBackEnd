package Algorithm.Programmers;
// 더 크게 합치기
// https://school.programmers.co.kr/learn/courses/30/lessons/181939

public class S181939 {
    public static int solution (int a, int b) {
//        StringBuilder aBuilder = new StringBuilder();
//        aBuilder.append(a).append(b);
        String strA = Integer.toString(a);
        String strB = Integer.toString(b);

        int resultInt1 = Integer.parseInt(strA + strB);
        int resultInt2 = Integer.parseInt(strB + strA);

        return Math.max(resultInt1, resultInt2);
    }

    public static void main(String[] args) {
        System.out.println(solution(9, 91));
    }
}
