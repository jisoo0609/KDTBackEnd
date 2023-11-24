package T231124;

public class D5Main {
    public static void main(String[] args) {
//        D5Car myCar = new D5Car(); // Car 클래스의 객체를 만듦. 자료형 Car
//        D5Car.count += 1;
//        myCar.brand = "Kia";
//        myCar.name = "K5";
//        myCar.fuel = 72;
//        myCar.beep();
//        myCar.printInfo();
//        myCar.drive(10);
//        System.out.println(D5Car.count); // count가 static 으로 선언. 클래스에서 관리
//
//        System.out.println("==========");
//
//        D5Car car = new D5Car();
//        D5Car.count += 1;
//        car.brand = "Hyundai";
//        car.name = "Sonata";
//        car.fuel = 80;
//        car.printInfo();
//        System.out.println(D5Car.count); // 2 출력

        D5Car someCar = new D5Car("K3", "Kia", 60);
//        someCar.name = "K3";
//        someCar.brand = "Kia";
//        someCar.fuel = 60;
        System.out.println(someCar.getBrand());
        someCar.printInfo();
        someCar.setBrand(100);
        someCar.printInfo();

        D5Car sonata = new D5Car();
        sonata.printInfo();

        // ???
//        someCar.brand = "Mercedes Benz";
//        someCar.name = "E-Class";
//        someCar.printInfo();

        System.out.println("==========");
        D5Person me = new D5Person("JISOO");
        for (int i=0; i<24; i++) {
            me.age();
        }
        System.out.println(me.getAge());
        me.sayHello();
    }
}
