package T231204;

public class TimeComplexity {
    // 자연수 n을 받아서 (입력검증 필요X)
    // 1부터 n까지 모든 자연수를 합하는 메서드

    public static int sumUntilN1(int n) {
        // 모든걸 합한 결과를 담을 변수를 0으로 설정
        int sum = 0;
        // 1부터 n까지 모든 자연수를 확인하며
        for (int i = 0; i < n; i++) {
            sum += i;
        }
        return sum;
    }

    // n * (n + 1) /2 를 하면 1부터 n까지의 자연수를 합한것과 동일하다
    public static int sumUntilN2(int n) {
        return n * (n + 1) / 2;
    }

    public static void main(String[] args) {
        System.out.println(sumUntilN1(5));
    }
}
