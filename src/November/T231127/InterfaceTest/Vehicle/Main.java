package November.T231127.InterfaceTest.Vehicle;

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        Ship ship = new Ship();
        makeNoise(car);
        makeNoise(ship);
    }

    public static void makeNoise(Beeper beeper) {
        beeper.beep();
    }
}
