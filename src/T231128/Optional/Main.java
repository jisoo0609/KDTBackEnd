package T231128.Optional;

import java.util.Optional;
import java.util.Random;

// Optional
// null 에 대비할 수 있는 대표적인 제너릭 클래스
// null safety
public class Main {
    public static void main(String[] args) {
        // 에러가 될 수도 안될수도
        // System.out.println(nullOrString().length());
        String nullable = nullOrString();
        if (nullable == null) System.out.println("get: null");
        else System.out.println(nullable);

        // null이거나 null이 아니거나 일반적인 흐름에서 사용 가능
        Optional<String> optionalString = Optional.ofNullable(nullOrString());
        if (optionalString.isEmpty()) {
            System.out.println(optionalString.get());
        } else {
            System.out.println("get: null");
        }

        // String result = Optional.ofNullable(nullOrString()).orElse("get: null");
        // 조건문을 통한 null 체크
        String result = nullOrString();
        if (result != null) {
            System.out.println(result);
        } else {
            System.out.println("got: null");
        }

        // 어떤 메서드든 Optional.ofNullable() 메서드를 통해 결과를 반환하게 한다
        // 정적 메서드 안에서 새로운 객체를 만들어 반환
        Optional<String> optionalResult = Optional.ofNullable(nullOrString());
        // isPresent : null이 아닌값이 들어올때 true
        // isEmpty : null일때  true
        if (optionalResult.isPresent()) {
            System.out.println(optionalResult.get());
        } else {
            System.out.println("got: null");
        }

        // 결과를 Optional로 받으면, orElse를 통해
        // 결과가 null일때 기본값을 설정할 수 있다
        String resultOrElse = Optional.ofNullable(nullOrString())
                // null이 아니면 그 값이,
                // null이면 인자로 전달한 값이
                .orElse("got: null from orElse");
        System.out.println(resultOrElse);

        // 메서드에서 직접 온 Optional을 다룸
        String resultFromOptional = nullOrOpt()
                .orElse("got: null from orElse method");
        System.out.println(resultFromOptional);
    }

    // 50% 확률로 null 반환
    public static String nullOrString() {
        Random random = new Random();
        if (random.nextInt() % 2 == 0)
            return "not null string";
        else return null;
    }

    // 메서드가 Optional을 반환하게 함
    public static Optional<String> nullOrOpt() {
        Random random = new Random();
        if (random.nextInt() % 2 == 0)
            // Optional.of로 Optional을 만든다
            return Optional.of("not null string");
        // null 결과는 Optional.empty()
        else return Optional.empty();
    }
}
