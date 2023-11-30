package November.T231127.InterfaceTest.Vehicle;

/*
    연료가 얼마나 들었는지에 대한 정보 (속성)
    연료가 얼마나 남았는지에 대한 정보를 반환하는 메서드
    연료를 설정하는 메서드
    운전하는 메서드, 실행시 주행거리 / 10 (정수) 만큼 연료 소모
    경적을 울리는 `beep`
 */
public class Car implements Beeper {
    protected int fuel; // 연료

    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    public void drive(int kilos) {
        System.out.println("drive car");
        this.fuel -= kilos / 10;
    }

    @Override
    public void beep() {
        System.out.println("빵빵");
    }
}
