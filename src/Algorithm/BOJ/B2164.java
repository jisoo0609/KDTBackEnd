package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 카드 2
// https://www.acmicpc.net/problem/2164
public class B2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Queue<Integer> cards = new LinkedList<>();

        // for를 이용해 1~N까지의 N개의 숫자를 Queue에 넣는다
        for (int i = 1; i <= n; i++) {
            cards.offer(i);
        }

        // Queue의 크기가 1보다 클 동안
        while (cards.size() > 1) {
            // Queue의 제일 앞의 아이템을 버리고
            cards.poll();
            // 그 다음 앞의 아이템을 빼서
            int item = cards.poll();
            // 제일 뒤로 넣는다
            cards.offer(item);
        }
        // 마지막 남은 아이템을 출력한다
        System.out.println(cards.poll());
    }
}
