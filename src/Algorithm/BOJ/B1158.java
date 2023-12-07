package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();

        // 큐에 1~n까지 숫자 넣음
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        sb.append("<");

        while (!queue.isEmpty()) {
            for (int i = 0; i < k-1; i++) {
                queue.offer(queue.poll());
            }
            if (queue.size() == 1) {
                sb.append(queue.poll()).append(">");
            } else {
                sb.append(queue.poll()).append(",");
            }
        }

        System.out.println(sb);
    }
}