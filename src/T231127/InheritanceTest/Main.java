package T231127.InheritanceTest;

public class Main {
    public static void main(String[] args) {
        Car sonata = new Car();
        refuel(sonata);
        System.out.println(sonata.getFuel());
        sonata.drive(100);
        sonata.beep();

        Truck porter = new Truck(100);
        refuel(porter);
        System.out.println(porter.getFuel());
        porter.drive(100);
        porter.beep();
        porter.addLoad(30);
        System.out.println(String.format("max load: %d, current load: %d", porter.getMaxLoad(), porter.getLoad()));

        // Car로 선언된 경우
        Car bongo = new Truck(100);
        // Truck으로 형변환하기 전까진 트럭의 기능 모름
        ((Truck)bongo).addLoad(10);
        if (isTruck((sonata))) {
            ((Truck)sonata).addLoad(20);
        } else {
            System.out.println("is not truck");
        }

//        porter.drive(30);
//
//        refuel(bongo);
//        bongo.drive(100);

    }

    public static boolean isTruck(Car car) {
        return car instanceof Truck;
    }

    public static void refuel(Car car) {
        car.setFuel(100);
    }
}
