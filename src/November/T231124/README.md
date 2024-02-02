# Class

## 객체와 클래스

- 객체
    - 클래스 바탕으로 만들어진 실체
- 클래스
    - 필요한 정보 담은 설계도
- Static
    - 정적
    - 움직이지 않음
    - 클래스에서 관리
- Method
    - 객체가 수행하는 기능

## 속성(Attribute)

### Car Class

- Car class가 가져야하는 정보 생성
- 변수 만드는 것과 유사
- 메서드 영역이 아닌 클래스 영역에서 선언
- 만들어진 객체마다 별도로 가지고 있음

```java
public class Car {
    // 총 도로를 달리고 있는 자동차의 갯수
    public static int count = 0;
    private final String brand; // 브랜드
    private final String name; // 차종
    private int fuel; // 탱크 상태
}
```

- . 을 통해서 class 외부로 가져올 수 있다
    - 단, 변수가 class 내에서 생성된 경우에만 제약 없이 가져올 수 있음

```java
Car car = new Car();
```

### 생성자(Constructor)

- 객체를 생성할 때 호출되는 메서드

```java
public Car(String name, String brand, int fuel) {
        System.out.println("==========");
        count++;
        this.name = name;
        this.brand = brand;
        this.fuel = fuel;
    }
```

- 생성자 Method Overloading 가능
    - 구분해서 생성자 만들 수 있음

```java
// 생성자 Method Overloading
    public Car() {
        System.out.println("==========");
        count++;
        this.name = "Sonata";
        this.brand = "Hyundai";
        this.fuel = 72;
    }
```

---

# 접근 제어자

## private

- 객체(자기자신)만 접근 가능함
- 내부의 메서드에서만 접근 가능
- 외부에서 함부로 수정되는 것 막음
- class의 public 메서드의 getter / setter 이용

## getter / setter

- 클래스 내의 변수 private으로 선언된 경우 getter / setter를 통해 접근 가능
- 정보 보호하고 외부로 노출되는 것을 방지
- 정보은닉

```java
public String getBrand() {
        return brand;
    }

    public void setBrand(int fuel) {
        this.fuel = fuel;
    }
```

- this.
    - 객체 자기 자신을 가리키는 키워드

## final

- 한번 할당된 이후에 변경 불가
- 생성자 또는 클래스 만드는 단계에서 한번만 할당 가능
- 이후 수정 불가, 추가 변경 어려움
- 성능 향상 목적

```java
private final String password;
```

---

# JAVA의 데이터 저장

- 메모리 상에 존재하는 위치 정함
- 메서드에서 필요한 공간(원시타입)은 대부분 stack memory에 만들어짐

## Stack Memory

- HW의 일부분을 자바가 사용하는 논리적 공간
- LIFO
- main을 제외한 모든 메서드는 호출 시 Stack Memory에 필요한 공간 할당
    - 충분한 메모리: frame 단위
    - 실제 데이터 할당
    - 메서드 종료 시 프레임 제거해 공간 남김
    - 다른 메서드가 Stack Memory의 공간을 할당

## Heap Space

- class, Instance, 객체는 stack에 직접 데이터 저장하지 않고 Heap Space에 저장
- 원시타입을 제외한 모든 참조 타입 저장
- 총 공간
    - Heap > Stack
- 공간 할당 소요 시간
    - Heap > Stack
- Stack frame 제거 시 Heap에서 사용한 저장공간도 사라지는 것은 아님
    
    → frame에서 main 메서드 종료
    
    - JVM의 Garbage Collector 가 Heap Space를 비워줌
    - 참조하는 변수 제거

---

# Pass by Value vs Pass by Reference

## Pass by Value

- 전달된 인자의 값만 복사
- JAVA는 Pass by Value 방식
    - JVM의 동적 방식→ 인자로 전달받은 객체. 같은 객체 사용하게 함

### Pass by Reference

- 전달된 인자가 실제로 존재하는 공간 전달
- 전달된 인자가 같은 곳에 있는지가 중요

---

# Class - String 및 Wrapper Class

# String

- String, Array → 참조타입
- 문자열 변환

```java
// 문자열 -> 정수 반환
        Integer parseInt = Integer.parseInt("1000");
        System.out.println(parseInt+100);
        // 문자열 -> 실수 변환
        Double parseDouble = Double.parseDouble("1.0");
        System.out.println(parseDouble);
        parseDouble = Double.parseDouble("3.141592");
        System.out.println(parseDouble);
        // 문자열 -> Long 변환
        System.out.println(Long.parseLong("10000000000000000"));
        // 정수 최댓값, 최솟값 상수
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        // Long 최댓값, 최솟값
        System.out.println(Long.MAX_VALUE);
        System.out.println(Long.MIN_VALUE);
        // Double
        System.out.println(Double.MAX_VALUE);
```

- 문자열 자르기

```java
// String
        String sentence = "Hello, today is 27th of November";
        // 문자열 길이
        System.out.println(sentence.length());
        // 문자열 자르기
        System.out.println(sentence.substring(7, 12));
        String[] strArray = sentence.split(" "); // 정규표현식 받음
        for (String str : strArray) {
            System.out.println(str);
        }

        String email = "asdfewrx@gmail.com";
        String[] mailSplit = email.split("@");
        for (String str : mailSplit) {
            System.out.println(str);
        }
```

- indexOf()
    - 특정 문자열 반환

```java
// 특정 문자열 찾기
        String source = "https://google.com/serch?q=";
        System.out.println(source.indexOf("google"));
```

- 문자열 한 글자씩 확인하는 방법
    1. for 이용
    
    ```java
            // 1. for i 반복
            // ex) index확인 필요한 경우
            for (int i = 0; i<source.length(); i++) {
                // 문자열을 배열 취급해 [i]번째 가져옴
                System.out.print(source.charAt(i)+" ");
            }
            System.out.println();
    ```
    
    1. string.toCharArray()
    
    ```java
    // ex) index 확인 필요X 문자열만 받아오고싶은경우
            for (char letter : source.toCharArray()) {
                // 문자열 내부에 저장된 문자 배열 반환하기
                System.out.print(letter+" ");
            }
            System.out.println();
    ```
    
- 각 글자가 영문인지 숫자인지 확인하는 방법
    
    ```java
    // 각 글자가 영문인지 숫자인지 확인하기
            for (char letter : source.toCharArray()) {
                // 문자가 숫자를 나타내는 문자인지 확인 -> isDigit()
                if (Character.isDigit(letter)) {
                    System.out.println(String.format("digit: %c", letter));
                }
                // 문자가 인간의 문자를 나타내는 문자인지 확인
                if (Character.isLetter(letter)) {
                    System.out.println(String.format("letter: %c", letter));
                }
            }
    ```
    

---

## 원시타입 Wrapper Class

- Integer
    - parseInt()
    - MAX_VALUES / MIN_VALUES 등
- Double
    - POSITIVE INFINITY 등

```java
// 1. 참조 타입이지만, String 처럼 값을 할당 가능
        String string = "";
        int primInt = 10;
        // int에 대응하는 참조 타입은 Integer
        Integer refInt = 10;

        // 2. 서로 상호 호환이 된다
        refInt = primInt;
        primInt = refInt;
        
        // 3. 사칙연산도 그냥 참조 타입을 바탕으로 사용 가능하다
        refInt *= 10;
        System.out.println(refInt);
        refInt /= primInt;
        System.out.println(refInt);

        Long refLong = 1000000000L;
        refLong *= 2;
        System.out.println(refLong);

        Character a = 'a';
```