package November.T231128.Object;

public class Main {
    public static void main(String[] args) {
        Person alex = new Student("Alex", 25, "CSE");
        Person brad = new Lecturer("Brad", 40, "Generics");
        Person alex2 = new Student("Alex", 25, "CSE");
        Person alex3 = new Lecturer("Alex", 25, "Korean");
        int a = 0;
        // 수많은 계산이 진행된 후,
        // int a 가 얼마인지 확인하려면
        System.out.println(a);
        // alex에 어떤값이 있는지 -> Getter 사용
        System.out.println(alex);
        System.out.println(brad); // false

        printPerson(alex);
        printPerson(brad);

        // equals
        System.out.println(alex == alex2); // 항상 false
        System.out.println(alex.equals(alex2)); // true
        System.out.println(alex.equals(alex3)); // false. 2번 같은 클래스 아님. 서로 다른 값을 가진 객체
        System.out.println(alex3.equals(alex)); // false

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

    }

    public static void printPerson(Person person) {
        System.out.println(person);
    }
}
