package T231127.D6Ex.Q3.Class;

import T231127.D6Ex.Q3.Interface.Display;
import T231127.D6Ex.Q3.Interface.PlaySound;
import T231127.D6Ex.Q3.Interface.Switchable;

public class Television implements Switchable, PlaySound, Display {

    private String broadcastStation; // 방송국
    private int channel; // 채널

    public Television(String broadcastStation, int channel) {
        this.broadcastStation = broadcastStation;
        this.channel = channel;
    }
    @Override
    public void switchOn() {
        System.out.println(String.format("TV 전원을 켭니다"));
    }

    @Override
    public void switchOff() {
        System.out.println(String.format("TV 전원을 끕니다"));
    }

    @Override
    public void playSoundOn() {
        System.out.println(String.format("TV 소리가 켜져있습니다"));
    }

    @Override
    public void playSoundOff() {
        System.out.println(String.format("TV가 음소거 상태입니다"));
    }

    @Override
    public void display() {
        System.out.println(String.format("%d번에서 %s 방송국의 방송이 진행중입니다", this.channel, this.broadcastStation));
    }
}
