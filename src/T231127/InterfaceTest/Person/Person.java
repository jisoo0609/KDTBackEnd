package T231127.InterfaceTest.Person;

public abstract class Person implements Comparable {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @Override
    // Comparable에서 구현을 요구하는 메서드
    // 두개의 객체의 대소를 비교하기 위함
    // JAVA에서 제공하는 정렬 기능을 활용
    public int compareTo(Object o) {
        return age - ((Person) o).age;
    }

    // 추상 메서드: 작동법(메서드 바디) 작성하지 않고,
    // 상속 받은 클래스에 구현을 위임하는 메서드
    public abstract void sayHello();

    public String getName() {
        return this.name;
    }
}