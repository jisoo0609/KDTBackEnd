package T231128.Object;

public class Lecturer extends Person {
    private String subject;

    public Lecturer(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    @Override
    public String toString() {
        return super.toString()+", Lecturer";
    }
}
