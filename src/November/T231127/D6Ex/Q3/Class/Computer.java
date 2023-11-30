package November.T231127.D6Ex.Q3.Class;

import November.T231127.D6Ex.Q3.Interface.Display;
import November.T231127.D6Ex.Q3.Interface.PlaySound;
import November.T231127.D6Ex.Q3.Interface.Switchable;

public class Computer implements Switchable, PlaySound, Display {
    private String site; // 사이트

    public String getSite() {
        return site;
    }

    @Override
    public void switchOn() {
        System.out.println(String.format("컴퓨터 전원을 켭니다"));
    }

    @Override
    public void switchOff() {
        System.out.println(String.format("컴퓨터 전원을 끕니다"));
    }

    @Override
    public void playSoundOn() {
        System.out.println(String.format("컴퓨터 소리가 켜져있습니다"));
    }

    @Override
    public void playSoundOff() {
        System.out.println(String.format("컴퓨터가 음소거 상태입니다"));
    }

    @Override
    public void display() {
        System.out.println(String.format("사이트 주소: %s의 화면을 보여주고 있습니다", this.site));
    }
}
