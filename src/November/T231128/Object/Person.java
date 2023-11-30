package November.T231128.Object;

import java.util.Objects;

/*
    이름과 나이를 속성으로 가지고
    모든 인자를 받는 생성자
 */
public abstract class Person {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Person() {}
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("%s, age: %d", name, age);
    }

    @Override
    public boolean equals(Object o) {
        // 1. 실제로 두 변수의 값이 동일한지
        if (this == o) return true;
        // 2. null이거나, 둘이 다른 클래스인지
        /* if (o == null || this.getClass() != o.getClass())
            return false;

         */
        // 서로 다른 자식 클래스가 일치하게 하고 싶다면
        if (!(o instanceof Person)) return false; // 이름과 나이가 같으면 true
        // 3. 나머지 속성을 비교하자 (다운캐스팅 필요)
        // 같은 클래스인지 확인했기때문에 다운캐스팅해도 문제 없음
        Person other = (Person) o;
        return
              this.age == other.age &&
              this.name.equals(other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
