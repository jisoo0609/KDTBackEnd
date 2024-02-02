# 파일 입출력

# Stream

## Stream

- 순서가 있는 데이터의 연속적인 흐름
- Stream<T> 데이터가 흘러감을 나타내는 객체

---

## Stream API

### Strema 생성

```java
String[] nameArray = {
                "Alex",
                "Dave",
                "Chad",
                "Brad"
        };
        // Stream<T>는 데이터가 흘러감을 나타내는 객체
        Stream<String> nameArrStream = Arrays.stream(nameArray);
```

```java
// 원시타입 스트림
        int[] intArray = {1, 23, 14, 53, 22, 15, 10, 6};
        IntStream intStream = Arrays.stream(intArray);

        // 문자열을 문자 스트림
        String email = "edujeeho@gmail.com";
        IntStream charStream = email.chars();
```

```java
// Collection.stream()
        List<String> nameList = new ArrayList<>();
        nameList.add("Alex");
        nameList.add("Dave");
        nameList.add("Chad");
        nameList.add("Brad");
        Stream<String> nameListStream = nameList.stream();
```

### Intermediate Operation

- filter()
    - 전달받은 함수를 바탕으로 참인 데이터만 남기는 Stream

```java
nameListStream
                // 데이터를 선별하는데,
                // 선별하는 기준을 전달해야 한다.
                // filter: 전달받은 함수를 바탕으로 참인 데이터만 남기는 Stream
                .filter(name -> name.contains("d"))
```

- sorted()

```java
// 데이터를 받아 전달받은 기준으로 정렬을 한다.
                .sorted(Comparator.reverseOrder())
```

### Terminal Operations

- 중간 작업의 결과 데이터를 최종적으로 활용하고 싶은 형태로 반환

```java
List<String> result = nameListStream.toList();
```

# Functional Interface

- 함수형 인터페이스
- 단 하나의 추상 메서드만 가지는 인터페이스
- Java의 함수형 프로그래밍의 기반
- 함수형 인터페이스를 바탕으로 람다 함수(익명 함수)를 만들 수 있다
- @FunctionalInterface 어노테이션
    - 하나의 추상 메소드만을 가지는지 컴파이럴가 체크
    - 두 개 이상의 추상메서드가 선언되어 있으면 컴파일 오류

## 람다 함수(lambda)

- 함수형 인터페이스가 구현할 메서드 하나
- 나머지 생략하고 하나의 메서드만 표시
- (왼쪽: 매개변수) → (오른쪽: 함수 코드)

```java
        NoArgRetFunction lambda = () -> System.out.println("Lambda Expression");
        runFunction(lambda);
```

- 메서드 직접 참조
    - 함수형 인터페이스 형태와 동일한 메서드는 :: 형태로 직접 전달 가능하다

```java
runFunction(String::length);
```

## 람다 함수 작성 유의법

- 메개변수 타입 런 타임시에 대입 값에 따라 자동 인식
- 하나의 매개변수만 있을 경우 () 생략 가능
- 하나의 실행문만 있다면 {} 생략 가능
- 매개변수 없다면 () 생략 불가
- 리턴값이 있는 경우 return 사용

# File IO

- JAVA에서 파일을 읽고 쓰는 방법

## FileReader & FileWriter

- 문자 기반이 파일을 읽어들이는 기본이 되는 클래스

---

## FileReader

## try-with-resource

- 프로그램은 파일을 사용하기 위해 열어야 한다
- 열고 나서 작업을 마친 후 닫아주는 것이 좋음
- 닫지 않으면 자원 소모, 파일 사용 불가 등의 사태 발생

```java
            try (FileReader fileReader = new FileReader("people.csv"); // 어떤 파일을 열것인지
            BufferedReader reader = new BufferedReader(fileReader)) {
            String line;
            while ((line = reader.readLine()) != null) {
                // 데이터를 모으고 정리하는 부분
                System.out.println(line);
                readLines.add(line);
                // 쉼표를 기준으로 나눈다
                String[] seperated = line.split(",");
                Person person = new Person(
                        seperated[0],
                        seperated[1],
                        Integer.parseInt(seperated[2]),
                        seperated[3]
                );
                people.add(person);
            }
        } catch (IOException e) {
            System.out.println("Error Opening File: " + e.getMessage());
        }
```

## Buffered Reader

- 파일을 읽기 위해서가 아니라 전체적인 입출력 과정에 버퍼링 기능을 더해주기 위해 사용

```java
BufferedReader reader = new BufferedReader(fileReader))
```

---

## FileWriter

- try-with-resource

```java
try (FileWriter fileWriter = new FileWriter("people2.csv");
             BufferedWriter writer = new BufferedWriter(fileWriter)) {
            for (String line : readLines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error Writing File "+ e.getMessage());
        }
```