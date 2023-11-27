package T231127.InterfaceTest.Person;
public class Lecturer extends Person {
    private String subject;

    public Lecturer(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    public void sayHello() {
        System.out.println(String.format(
                "Hello, I'm %s, today's subject is %s.",
                getName(), this.subject
        ));
    }
}