package November.T231127.D6Ex.Q4.Class;

import November.T231127.D6Ex.Q4.Interface.NoiseMaker;

public class Car implements NoiseMaker {
    private String sound;

    public Car(String sound) {
        this.sound = sound;
    }

    @Override
    public String noise() {
        return sound;
    }

    @Override
    public void noiseMaker() {
        System.out.println(String.format("자동차는 %s을 울린다", this.sound));
    }
}
