package T231123.D4Ex;
/*
    원반을 끼울 수 있는 탑 3개에,
    다양한 크기의 원반 n개가, 큰것이 아래쪽에 위치하도록
    하나의 탑에 끼워져 있다.
    이 원반은 옮길 수 있는데,

    한번에 하나의 원반만을 옮길 수 있으며,
    작은 원반 위에 큰 원반이 잠시라도 올라가서는 안된다.

    라는 조건을 지키면서 모든 원반을 한 탑에서 다른 탑으로 이동하는 문제를
    하노이의 탑이라 부른다.
    한 탑에서 원반을 하나 꺼내 다른 탑으로 옮긴 횟수를 센다고 했을 때,
    n개의 원반을 총 몇번 옮겨야 하는지를 구하는 메서드를 작성하시오.
 */

public class H6Methods {
    static int cnt =0;
    public static int move(int n, char start, char temp, char end) {
        cnt++;
        if (n == 1) {
            System.out.println(String.format("%c -> %c로 이동", start, end));
        } else {
            move(n-1, start, end, temp);
            System.out.println(String.format("%c -> %c로 이동", start, end));
            move(n-1, temp, start, end);
        }
        return cnt;
    }

    public static int hanoi(int n) {
        // n < 1 = -1
        if (n < 1) return 0;
        // f(1) = 1
        if (n == 1) return 1;
        else return hanoi(n-1) * 2 + 1;
    }
    public static void main(String[] args) {
        System.out.println(move(3, 'A', 'B', 'C'));
    }
}
