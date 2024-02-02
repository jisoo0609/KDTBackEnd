# JAVA의 데이터 표현

# Variable / Types

## 변수 명 짓기

- JAVA: Camel Case
- Python: snake_case

## JAVA의 데이터 표현

- int, long, double, flot
- 변수 선언: 메모리(RAM) 상 변수가 들어갈 공간 확보

```java
int a; // int 4byte(32bit)
long a; // long 8byte(64bit)
```

- 이진법 사용해 숫자 표현 → 문자, 숫자 등

---

# 문자(String)

- 숫자에 각각의 문자 대응
- 저장된 데이터 형태: 숫자

### Encoding

- 어떤 문자 숫자에 대응. 코드화

### Decoding

- 코드화되어있는 값 다시 변환

## 표준: ASCII Code

- 7bit(0~127, 128개)
- ‘A’: 65 / ‘a’: 97

## 유니코드(UTF-8)

- 2byte
- ASCII code의 한계를 극복하기 위해 고안
- 첫 1byte ASCII Code와 호환

---

# 정수

## 음이 아닌 정수(0과 자연수) → 이진법

14 = 0000 1110

- 문제점
    1. 0 표현 방법 2가지 존재

       1000 0000

       0000 0000

    2. +, - 기능 부호 따져야함

## 정수 부호 표현

### 음수 표현

- 2의 보수
    - 더해서 특정한 수가 되도록 하는 숫자
    - (bit) 두 숫자 더했을때 0이 되도록 하는 숫자(2의 보수) → 음수취급, 저장
- ex)
    1. 절대값 2진수로 표현

       -14 → 14 → 1110

    2. (8bit로 가정) 남는 bit 0으로 채움

       1110 → 0000 1110

    3. 각 비트 0→1, 1→0으로 바꿈 (1의 보수)

       0000 1110 → 1111 0001

    4. 결과에 1을 더함

       1111 0001 → 1111 0010

    5. 절대값의 양수와 더했을때 0이 되어야 함

       0000 1110 + 1111 0010 = 1 0000 0000

---

# 상수 부동 소수점

- 특정 비트들은 정수, 특정 비트들은 유리수 → 범위 한정적. 현재 사용X

## 부동소수점(floating point)

- 정수부 숫자 한자리만 남긴 다음 소숫점 몇자리 옮겼는지 기록

ex)

1. 실수 2진수로 변환

   10.25 → 1010.01

2. 정수부가 한 자리만 남도록 이동, 이동한 만큼 2의 거듭제곱으로 표현 (정규화)
3. 지수에 Bias 더함 (음수 → 양수화)
4. 부호를 부호비트에, 지수를 지수부에, 유효숫자는 가수부에 저장
- double(64bit) > float(32bit) → 사용 빈도 double ⬆️

---

# 형변환(Type Casting)

<aside>
💡 byte → short → int → long → float → double

</aside>

- 더 큰 자료형 → 작은 자료형: 강제적 형변환 적용

```java
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
```