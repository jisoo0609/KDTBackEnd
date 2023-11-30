package November.T231128.Exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = 10;
        int b = 0;

//        int a = sc.nextInt();
//        int b = sc.nextInt();

        try {
            a *= 2;
            a *= 3;

            System.out.println(divide(a, b));
        } catch (ArithmeticException | NullPointerException e) {
            // 예외가 발생하면 실행되는 곳
            System.out.println(String.format("Sorry, this happend: %s",e.getMessage()));
        }finally {
            // 예외 발생으로 인한 catch의 실행과 상관 없이 실행되는 곳
            System.out.println("Bye!");
            // 원상복구
            a /= 2;
            b /= 3;
        }

        System.out.println(a);
        System.out.println(b);
    }

    public static void readFileThrows(String filename)
            throws FileNotFoundException {
        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine())
            System.out.println(scanner.nextLine());
    }

    // 두개의 정수를 받아 나누어서 정수를 반환하는 정적 메서드 divide
    public static int divide(int a, int b) {
        return a/b;
    }

    public static double divideToDouble(int a, int b) {
        // 수동으로 예외를 발생시키고 싶다
        if (b == 0) throw new ArithmeticException("Division by Zero");
        return (double) a/b;
    }
}
