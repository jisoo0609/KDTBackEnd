package T231127.InheritanceTest;

// 가장 먼저 자동차의 모든 기능을 가지게 만듦 -> extends

import T231127.InheritanceTest.Car;

public class Truck extends Car {
    // 짐을 실을 수 있는 한도
    // 자동차에는 없지만 트럭에는 있는 속성
    private final int maxLoad;
    // 현재 실린 짐
    private int load;
    public int getMaxLoad() {
        return maxLoad;
    }

    public int getLoad() {
        return load;
    }


    public Truck(int maxLoad) {
        this.maxLoad = maxLoad;
        this.load = 0;
    }

    // Car와는 다르게 동작하는 drive
    @Override
    public void drive(int kilos) {
        System.out.println("drive truck");
        this.fuel -= load /(maxLoad/10);
        super.drive(kilos); // super. 로 부모클래스의 메서드 사용
    }
    
    // 짐을 인자로 받아, 'maxLoad' 이하면은 추가하고
    // 아니라면 추가하지 않은 다음
    // 추가 성공 여부를 boolean으로 반환하는 메서드
    public boolean addLoad(int load) {
        if (this.load > this.maxLoad) {
            return false;
        }
        this.load += load;
        return true;
    }
}
