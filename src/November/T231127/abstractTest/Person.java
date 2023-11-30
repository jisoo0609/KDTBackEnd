package November.T231127.abstractTest;

/*
    사람을 만들고 (이름)(인사를 할거지만, 누가 하는지에 따라 다르게 하고 싶다)
    학생을 만들고 (이름, 전공) (인사)
    강사를 만들고 (이름, 주제) (인사)
 */

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
