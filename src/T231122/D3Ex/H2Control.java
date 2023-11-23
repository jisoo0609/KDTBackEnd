package T231122.D3Ex;

import java.util.Scanner;

/*
    축구리그에서는 승점을, 승리시 3점 무승부시 1점, 패배시 0점을 획득한다.
    남은 경기와 목표 승점이 주어졌을 때,
    남은 경기에서 목표 승점을 넘을 수 있으면 필요한 최소 승수를
    없으면 최고 승점을 출력하여라.
 */
public class H2Control {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("남은 경기 수를 입력하세요: ");
        int remain = sc.nextInt(); // 남은 경기

        System.out.print("현재 승점을 입력하세요: ");
        int current = sc.nextInt(); // 현재 승점

        System.out.print("목표 승점을 입력하세요: ");
        int goal = sc.nextInt(); // 목표 승점

        // 넘을 수 있는지를 판단하기 위해 전부 이겼다고 가정
        int maxScore = current + remain * 3;

        // 목표 점수 넘었는지 여부 판단
        if (maxScore >= goal) {
            // 승 한번이 무승부로 바뀌면 줄어드는 점수 -> 2점
            // 최고 점수 - 목표점수 = 여유 점수(목표보다 초과로 달성된 점수)
            // 여유 점수/2 만큼 덜 이겨도 나머지를 다 무승부로 끝내면 필요한 최소 승수
            int minWins = remain - (maxScore - goal) / 2;
            //필요 승수가 음수일 경우 0으로 바꿈
            minWins = minWins < 0 ? 0 : minWins;
            System.out.println(String.format("최소 승수 %d", minWins));
        } else {
            System.out.println(String.format("최고 승점: %d", maxScore));
        }

    }
}
