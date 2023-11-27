package T231127.abstractTest;

public class Main {
    public static void main(String[] args) {
        Person alex = new Student("Alex","CSE");
        Person brad = new Student("Brad","CSE");
        Person chad = new Lecturer("Chad", "OOP");
        alex.sayHello();
        brad.sayHello();
        chad.sayHello();

        Person[] people = {alex, brad, chad};
        for (Person person : people) {
            person.sayHello();
        }
    }
}
