package T231121;

public class D2Operators {
    public static void main(String[] args) {
        int plus = 10 + 20;
        int minus = 20 - 10;
        int multiply = 20 * 10;
        int divide = 20 / 10; // 정수 값이 아닐수 있는데 int로 선언되어 정수로 표현됨
        int module = 15 % 10;

        System.out.println(plus); // 30
        System.out.println(minus); // 10
        System.out.println(multiply); // 200
        System.out.println(divide); // 2
        System.out.println(module); // 5

        // 사칙연산의 우선순위
        int result = 10 + 5 * 3;
        System.out.println(result);

        // 괄화가 최우선
        result = (10 + 5) * 3;
        System.out.println(result);

        // %의 우선순위 -> * / 과 동일함
        result = (10+5%3)/3+2*3;
        System.out.println(result);

        // 형변환(Type Casting)
        int intResult = (int)2.1;
        System.out.println(intResult);

        // 선 변환을 통한 나누기 연산
        int left = 21;
        int right = 10;
        double castedResult = (double) left / right;
        System.out.println(castedResult);

        // 명시적 형변환 데이터 손실
        long bigInt = 4294967296L;
        System.out.println((int)bigInt);

        // String 덧셈
        System.out.println("여기에 10을 입력하시오: "+10);

        // 산술연산자
        int temperature = 38;
        int age = 20;
        // 체온은 37 이하면서 나이는 20 이상
        boolean notSick = temperature <= 37;
        // 나이는 20 이상
        boolean isOfAge = age >= 20;
        // 입장 가능한가
        boolean canEnter = notSick && isOfAge;
        System.out.println(canEnter);

        // 미세먼지 수치
        int dust = 37;
        // 80이하면 "좋음", 아니면 "나쁨"
        String message = dust <= 80 ? "좋음" : "나쁨";

        System.out.println(String.format("미세먼지 수치: %d, (%s)", dust, message));
    }
}
