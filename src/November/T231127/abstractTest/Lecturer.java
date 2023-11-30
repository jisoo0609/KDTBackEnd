package November.T231127.abstractTest;

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
