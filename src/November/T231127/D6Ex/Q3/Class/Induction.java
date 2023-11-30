package November.T231127.D6Ex.Q3.Class;

import November.T231127.D6Ex.Q3.Interface.CookingUtensil;
import November.T231127.D6Ex.Q3.Interface.Switchable;

public class Induction implements Switchable, CookingUtensil {
    private String cooker; // 요리도구

    public Induction(String cooker) {
        this.cooker = cooker;
    }
    @Override
    public void switchOn() {
        System.out.println(String.format("인덕션 전원을 켭니다"));
    }

    @Override
    public void switchOff() {
        System.out.println(String.format("인덕션 전원을 끕니다"));
    }

    @Override
    public void cookingUtensil() {
        System.out.println(String.format("%s를 사용한 요리가 가능합니다", cooker));
    }
}
