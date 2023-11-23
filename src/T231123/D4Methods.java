package T231123;

public class D4Methods {
    // main 메서드
    public static void main(String[] args) {
        System.out.println("이것은 메서드 입니다");
        System.out.println(addTwoInt(10, 20));

        int[] nums = {2, 3, 1, 4, 6};
        System.out.println(findOneBreak(nums));
        System.out.println("-------------");
        System.out.println(findOneBreak(nums));

        System.out.println("재귀함수");
        System.out.println(factorial(5));

        System.out.println("Method Overloading");
        int intA = 2; int intB = 3;
        long longA = 2; long longB = 3;
        System.out.println(add(intA, intB));
        System.out.println(add(longA, longB));
        // int + long -> long add(long a, long b)가 실행됨
        // long add(int a, long b) 형태의 메서드가 있다면 우선순위 바뀜
        System.out.println(add(intA, longB));
    }

    // 두개의 정수를 더하는 메서드
    public static int addTwoInt(int a, int b) {
        return a + b;
    }

    // 두개의 정수를 더하고 두배 하여라
    public static int addAndTwice(int a, int b) {
        return (a+b)*2;
    }

    // 세개의 정수를 받아서, 합한 후 3으로 나눈 몫을 반환하는 메서드
    public static int divide(int a, int b, int c) {
        return (a+b+c)/3;
    }

    // 정수 배열을 받아, 1이 어디 있는지 반환, 없으면 -1
    public static int findOneReturn(int[] numbers) {
        // 부정 데이터 입력 방지
        if(numbers.length == 0) { // 배열의 길이가 0인경우 데이터 없음
            return -1;
        }
        int index = -1;
        for (int i = 0; i < numbers.length; i++) {
            // 찾았다!
            if (numbers[i] == 1) {
                return i;
            }
        }
        System.out.println("for 종료");
        return -1;
    }

    public static int findOneBreak(int[] numbers) {
        int index = -1;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 1) {
                index = i;
                break;
            }
        }
        System.out.println("for 종료");
        return index;
    }

    // n! = n*(n-1)!
    // n == 1 || n == 0 -> n! = 1
    public static int factorial(int n) {
        if (n == 1 || n == 0) {
            return 1;
        } else {
            return n * factorial(n-1);
        }
    }

    // Methods Overloading
    // 메서드 호출하는 코드에서 코드 활용도가 높아진다
    public static int add(int a, int b) { // int + int
        return a + b;
    }
    public static long add(long a, long b) { // long + long
        return a + b;
    }
    public static long add(int a, long b) {
        return  a + b;
    }

    // Varargs - 가변인자
    // public static int varargAvg(int[] ints)
    public static int varargAvg(int... ints) {
        int sum = 0;
        // 사용은 배열 쓰듯이
        for (int i = 0; i < ints.length; i++) {
            sum += ints[i];
        }
        return sum / ints.length;
    }
}
