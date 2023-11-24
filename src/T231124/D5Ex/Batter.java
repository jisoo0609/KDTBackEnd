package T231124.D5Ex;

public class Batter {
    private int pa; // 타석수(Plate Appearances)
    private int hit; // 안타수
    private int walks; // 볼넷수
    private int tb; // 루타수(Total Bases)

    public Batter() {
        this.pa = 0;
        this.hit = 0;
        this.walks = 0;
        this.tb = 0;
    }

    // 안타
    public void hit(int bases) { // 몇루타
        if (1>bases || bases > 4) {
            System.out.println("잘못된 값을 입력했습니다");
        }
        pa++;
        hit++;

        for (int i=0; i<bases; i++) {
            tb++;
        }
    }

    public void out() { // 아웃
        pa++;
    }

    public void walk() { // 볼넷
        pa++;
        walks++;
    }

    public double batAvg() { // 타율
        return (double) hit / (pa - walks);
    }

    public double onBasePer() { // 출루율
        return (double) (hit + walks) /pa;
    }

    public double slugPer() {
        return (double) tb /(pa-walks);
    }

    public double ops() {
        return onBasePer()+slugPer();
    }
}
