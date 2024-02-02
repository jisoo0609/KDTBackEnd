# 객체지향 프로그래밍

- 명령형 프로그래밍 → 절차지향 프로그래밍 → 객체지향 프로그래밍
    - 절차지향 프로그래밍: Procedure Call. 프로시저 호출을 바탕으로 실행
    - ex) C

---

# Method

## 함수 VS 메소드

- 함수
    - 독립적으로 실행 가능
- 메소드
    - 특정 클래스와 연결되어 클래스 객체에서 수행 가능
    - 클래스 내부에서 수행. 함수와 유사
    - 기능을 이해할 수 있는 이름 작성 → 추상화(Abstraction)와 연관

- 두 개의 정수를 더하는 메소드
    - return type: int
    - parameter: a, b

```java
public static int addTwoInt(int a, int b) {
        return a + b;
    }
public static void main(String[] args) {
        System.out.println(addTwoInt(10, 20)); 
```

---

## 재귀함수

- 메소드 안에서 자기 자신 참조

## ex)

### 계승(Factorial)

- 1~n까지의 자연수 전부 곱한 수
- $f(n) = n * f(n-1)$

```java
public static int factorial(int n) {
        if (n == 1 || n == 0) {
            return 1;
        } else {
            return n * factorial(n-1);
        }
    }
```

## 피보나치수열

```java
public static int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        } else {
            return fib(n-1) + fib(n-2);
        }
    }
```

---

# Method Overloading

- 매개변수의 타입만 다르면 같은 이름의 메서드 선언 가능
- 다형성(Polymorphism)

```java
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
```

- 호출하는 인자의 자료형을 보고 판단

---

## Variable-Length Argument List(가변인자)

- 임의의 개수 받음
- 배열과 유사하게 사용 가능하지만 임의의 인자 넣음
- 배열 X. 배열 사용가능한 경우 배열 사용

```java
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
```