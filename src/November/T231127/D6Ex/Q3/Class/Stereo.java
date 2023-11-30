package November.T231127.D6Ex.Q3.Class;

import November.T231127.D6Ex.Q3.Interface.PlaySound;
import November.T231127.D6Ex.Q3.Interface.Switchable;

public class Stereo implements Switchable, PlaySound {
    @Override
    public void switchOn() {
        System.out.println(String.format("스피커 전원을 켭니다"));
    }

    @Override
    public void switchOff() {
        System.out.println(String.format("스피커 전원을 끕니다"));
    }

    @Override
    public void playSoundOn() {
        System.out.println(String.format("스피커 소리가 켜져있습니다"));
    }

    @Override
    public void playSoundOff() {
        System.out.println(String.format("스피커가 음소거 상태입니다"));
    }
}
