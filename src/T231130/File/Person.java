package T231130.File;

//데이터를 들고있는 java 객체이다
// Plain Old Java Object

public class Person {
    private String name;
    private String email;
    private int age;
    private String gender;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public Person() {

    }

    public Person(String name, String email, int age, String gender) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.gender = gender;
    }
}
