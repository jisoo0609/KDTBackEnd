# 객체 지향 프로그래밍

# Object Oriented Programming

- 캡슐화(Encapsulation)
- 상속(Inheritance)
- 다형성(Polymorphism)
- 추상화(Abstraction)

## 캡슐화(Encapsulation)

- 데이터와 기능 하나로 묶어 활용
- 자바에선 Class
- 외부 코드가 내부의 확장 고려하지 않음
- 내부 구현 숨김
    - 접근 제어자 사용(public, private, protected 등)

## 상속(Inheritance)

- 이미 존재하는 클래스를 상속받아 만들어진 기능 재활용
- 상속받은 기능 더 확장 가능
- 자식 클래스는 부모 클래스의 속성, 기능 공유하고 덮어써 독자적 기능 구현 가능
- 코드 재사용성, 확장성 향상

## 다형성(Polymorphism)

- 서로 다른 개체가 하나의 공통된 클래스 형태로 취급됨
- 메서드 오버로딩(Method Overloading)
    - 같은 이름의 메서드가 여러 기능을 가짐
- 메서드 오버라이드(Method Override)
    - 같은 메서드가 어떤 객체가 사용하는가에 따라 다른 기능을 가짐

## 추상화(Abstraction)

- 실제 기능 만들어지지 않은(method) 추상 클래스와 인터페이스를 바탕
- 실제 기능 구현을 자식클래스(Concrete Class)에 위임

---

# Inheritance & Compositoin

## Composition

- has a 관계인 경우 사용 가능

## @Override

- 부모에서 작성된 것과 다른 메서드 작성

## Abstract Class & Interface (implements)

- Concrete Class (구상 클래스)
    - 모든 데이터와 기능이 구현된 부모와 자식이 강하게 결합
- Coupling (결합도)
    - 서로에게 의존하는 정도
    - 한쪽이 바뀌면 반대쪽도 바뀌어야 함

→ 좀 더 추상화된 방법 필요: Abstract Class & Interface

---

## Abstract Class

- 모두가 공유하기 위한 속성을 구현한 클래스
- 만들지 않은 기능이 존재하는 클래스
- 메서드에서 일반 클래스와 가장 큰 차이 존재
    - abstract Method
        - 작동법(method body) 작성하지 않고, 상속 받은 클래스에 구현을 위임
- abstract class

```java
public abstract class Person {
    private String name;
    public String getName() {
        return name;
    }
    public Person(String name) {
        this.name = name;
    }

    // 추상 메서드 - 작동법(메서드 바디)을 작성하지 않고,
    // 상속 받은 클래스에 구현을 위임하는 메서드
    public abstract void sayHello();
}
```

- extends 이용해 상속

```java
public abstract class Person {
    private String name;
    public String getName() {
        return name;
    }
    public Person(String name) {
        this.name = name;
    }

    // 추상 메서드 - 작동법(메서드 바디)을 작성하지 않고,
    // 상속 받은 클래스에 구현을 위임하는 메서드
    public abstract void sayHello();
}
```

```java
public class Lecturer extends Person {
    private String subject;
    public Lecturer(String name, String subject) {
        super(name);
        this.subject = subject;
    }

    public void sayHello() {
        System.out.println(String.format("Hello, I'm %s, and teaching %s", getName(), subject));
    }
}
```

## Interface (implements)

- 구현해야 하는 기능인 추상 메서드의 모음
- 어떤 클래스가 반드시 만들어야하는 기능
- 동류가 아닌 같은 기능 구현
- 상위 클래스가 아닌 특정 기능을 추가하고 싶을 때
    - ex) Comparable
- 두 클래스가 큰 관계는 없지만 비슷한(같은) 기능을 보장

  → General

- 서로 다른 객체가 같은 기능 가짐

  ex) 운전함, 전원을 켬 등

- ex)
    - Interface 생성

    ```java
    public interface Beeper {
        // Interface에는 추상 메서드만 존재한다.
        void beep();
    }
    ```

    - implements 이용해 클래스에서 구현 가능

    ```java
    public class Car implements Beeper {
        protected int fuel; // 연료
    
        public int getFuel() {
            return fuel;
        }
    
        public void setFuel(int fuel) {
            this.fuel = fuel;
        }
    
        public void drive(int kilos) {
            System.out.println("drive car");
            this.fuel -= kilos / 10;
        }
    
        @Override
        public void beep() {
            System.out.println("빵빵");
        }
    }
    ```


---

# Object Class

- 자바의 모든 클래스가 상속 받을 수 있음

```java
public interface Comparable {
    int compareTo(Object o);
}
```

```java
    @Override
    // Comparable에서 구현을 요구하는 메서드
    // 두개의 객체의 대소를 비교하기 위함
    // Java에서 제공하는 정렬 기능을 활용할 때 사용됨
    public int compareTo(Object o) {
        return age - ((Person) o).age;
    }
```

- toString()
    - Object형 이면 toString 가져옴
    - @Override

    ```java
        @Override
        public String toString() {
            return super.toString()+", Student";
        }
    ```

    ```java
        @Override
        public String toString() {
            return super.toString()+", Lecturer";
        }
    ```

- instanceof
    - 부모클래스 기준
    - 서로 다른 자식 클래스가 일치하게 싶은 경우

    ```java
    if (!(o instanceof Person)) return false;
    ```

- hashCode()
    - equals가 일치하면 hasCode의 결과도 같아야 함
    - 임의의 입력에 대헤 일정한 길이의 함수의 출력 return

    ```java
        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }
    ```


---

# null

- NULL
    - ASCII CODE 0에 대응되어있는 특수문자
- 참조타입(String)
    - 주소가 들어감
    - 할당된 주소 없는 경우 NULL
    - 명확한 주소 X, 값이 존재하지 않는 경우 → Null Pointer

<aside>
💡 NullPointerException이 발생하지 않도록 주의해야함

</aside>

```java
        // null
        Person noName = new Student();
        System.out.println(noName.getAge()); // 0
        System.out.println(noName.getName()); // null
        // System.out.println(noName.getName().equals("Alex")); // NullPointerExcpetion. "Alex"가 String 객체가 아님
        System.out.println("Alex".equals(noName.getName()));
        if (noName.getName() != null)
            noName.getName().equals(alex.getName());

        try {
            System.out.println(noName.getName().equals("Alex"));
        } catch (NullPointerException e) {
            System.out.println("name was null");
            System.out.println(e.getMessage());
            // e.printStackTrace() 좋지는 않지만 에러 메세지 출력해주는 코드
        }
```