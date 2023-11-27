package T231127.D6Ex.Q4.Class;

import T231127.D6Ex.Q4.Interface.NoiseMaker;

public class Megaphone implements NoiseMaker {
    private String sound;

    public Megaphone(String sound) {
        this.sound = sound;
    }

    @Override
    public String noise() {
        return sound;
    }

    @Override
    public void noiseMaker() {
        System.out.println(String.format("확성기는 %s을 울린다", this.sound));
    }
}
