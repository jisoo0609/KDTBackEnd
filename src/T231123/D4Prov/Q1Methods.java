package T231123.D4Prov;
/*
    두 정수(int)를 인자로 받아,
    두 정수 값의 차이의 절댓값을 반환하는 "diff"메서드를 작성

    +
    어떤 정수를 받아서 절대값을 반환하는 메서드 "abs"를 작성
 */

public class Q1Methods {
    public static int abs(int n) {
        if (n<0) {
            return -n;
        }
        return n;
    }

    public static int diff(int a, int b) {
        return abs(a-b);
    }

    public static void main(String[] args) {
        System.out.println(diff(-4,7));
    }
}
