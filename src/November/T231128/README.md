# **Exception**

- 예상하지 못한 상황에서 어떻게 대처할 것인지 처리하는 과정
- 예외처리

<aside>
💡 **try - catch**

</aside>

## try - catch

- try에서 실행하고 예외 발생한 경우 catch에서 잡아서 예외 처리

  → 프로그램이 종료되지 않고 다음으로 넘어감


### finally

- 예외 발생해 catch의 실행 여부와 상관 없이 실행됨

```java
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
```

- **e.getMessage()**
    - 무슨 문제가 발생했는지 나타냄
    - error message 출력
- **exit code**
    - 프로그램이 정상적으로 동작, 완료되었는지 확인
    - 0인 경우: 제대로 된 종료. 프로그램이 정상적으로 종료됨
    - 1인 경우: 프로그램의 비정상적 종료가 일어남


## Throwable

- Exception
    - 기대하지 않은 상황에 대한 예외 처리 필요
        1. RunTimeException
        2. Exception
- Error
    - ex) Stack Overflow: JVM 단위에서 발생. 개발자가 처리 불가능한 에
- checked exception
    - 코드 단위에서 예외처리 선으로 필요
        - ex) FileNotFoundException: 자바 단위에서 예외처리 어렵기 때문에 예외처리 경고

---

# Generic

- Type 자체를 변수로 받는 기능
- int → long → double …
- **Generic Type Reference**
    - 사용자가 원하는 대로 사용
- Class, Interface, Method를 일반적인 상황에서 활용 → 재사용성 ⬆️

<aside>
💡 <T>

</aside>

- Type parameter
- T를 타입처럼 사용할 수 있음

### ArrayWrapper

```java
public class ArrayWrapper<T extends Comparable<T>> {
    private T[] array;

    public ArrayWrapper(T[] array) {
        if (array == null)
            throw new IllegalArgumentException("null array provided");
        this.array = array;
    }

    public boolean contains(T target) {
        for (T item : this.array) {
            if (item == null) continue; // T형이기 때문에 null인 경우도 고려 필요
            if (item.equals(target)) return true;
        }
        return false;
    }

    // 최댓값 비교
    // class이름<T extends Comparable<T>>
    // Comparable 구현 필요
    public T max() {
        T max = this.array[0];
        for (T item : this.array) {
            if (item == null) continue;
            if (max == null) max = item;
            else if (item.compareTo(max) > 0) max = item;
        }
        return max;
    }

}
```

### Main

```java
public static void main(String[] args) {
        Integer[] intArray = {10, 20, 30};
        ArrayWrapper<Integer> integerArrayWrapper = new ArrayWrapper<>(intArray);
        System.out.println(integerArrayWrapper.length());
        System.out.println(integerArrayWrapper.contains(10));
        System.out.println(integerArrayWrapper.contains(30));
        System.out.println(integerArrayWrapper.contains(15));

        Double[] doubleArray = {1.0, 2.3, 4.5};
        ArrayWrapper<Double> doubleArrayWrapper = new ArrayWrapper<>(doubleArray);
        System.out.println(doubleArrayWrapper.length());
        System.out.println(doubleArrayWrapper.contains(1.));
        System.out.println(doubleArrayWrapper.contains(2.31));
    }

public static <T> boolean contains(T[] source, T target) {
        for (T item : source) {
            if (item == null) continue;
            if (item.equals(target)) return true;
        }
        return false;
    }
```

- 여러개의 타입 파라미터 사용 가능. & 연산으로 추가
- 문자열 한 글자 씩 확인하는 방법
    1. for

        ```csharp
        // 1. for i 반복// ex) index확인 필요한 경우for (int i = 0; i<source.length(); i++) {
        // 문자열을 배열 취급해 [i]번째 가져옴
            System.out.print(source.charAt(i)+" ");
        }
        System.out.println();
        ```

    2. toCharArray()

        ```less
        // ex) index 확인 필요X 문자열만 받아오고싶은경우for (char letter : source.toCharArray()) {
        // 문자열 내부에 저장된 문자 배열 반환하기System.out.print(letter+" ");
         }
         System.out.println();
        ```