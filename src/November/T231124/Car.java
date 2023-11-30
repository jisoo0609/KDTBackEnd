package November.T231124;

public class Car {
    // 총 도로를 달리고 있는 자동차의 갯수
    public static int count = 0;
    private final String brand; // 브랜드
    private final String name; // 차종
    private int fuel; // 탱크 상태

    // 생성자 - 객체를 만들때 호출되는 메서드
    public Car(String name, String brand, int fuel) {
        System.out.println("==========");
        count++;
        this.name = name;
        this.brand = brand;
        this.fuel = fuel;
    }

    // 생성자 Method Overloading
    public Car() {
        System.out.println("==========");
        count++;
        this.name = "Sonata";
        this.brand = "Hyundai";
        this.fuel = 72;
    }

    // getter, setter
    public String getBrand() {
        return brand;
    }

    public void setBrand(int fuel) {
        this.fuel = fuel;
    }

    // 클락션 울리는 기능
    public void beep() {
        System.out.println("빠아아앙");
    }

    // 가진 정보를 출력하는 기능
    public void printInfo() {
        System.out.println(String.format("name:\t%s", name));
        System.out.println(String.format("brand:\t%s", brand));
        System.out.println(String.format("fuel:\t%s", fuel));
    }

    // 특정 거리를 이동하는 기능
    public void drive(int kilo) {
        fuel -= kilo/2;
        System.out.println(String.format("Moved: %dkm, Fuel: %d", kilo, fuel));
    }

}
