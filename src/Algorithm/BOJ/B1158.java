package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 정답을 담기 위한 리스트
        // 담을 원소의 갯수를 알고 있다면 생성자 생성시 그 값을 전달해 배열을 미리 키울 수 있다
        List<Integer> result = new ArrayList<>(n);
        // 요세푸스 문제 정의대로 사람을 빼기 위한 큐
        Queue<Integer> people = new LinkedList<>();

        // 큐에 1~n까지 숫자 넣음
        for (int i = 1; i <= n; i++) {
            people.offer(i);
        }

        // 현재 몇번째 사람인지를 기록한 뒤
        int round = 0;
        // 큐가 빌때까지 반복
        while(!people.isEmpty()) {
            int person = people.poll();
            // 이번 사람이 탈락할 차례인지 판단
            if (round == k-1) {
                // 맞으면 result로
                result.add(person);
                // 초기화
                round = 0;
            }
            else {
                // 아니면 다시 큐로
                people.offer(person);
                round++;
            }
        }

        String resultString = result.toString();
        // 부문문자열 만들기
        resultString = resultString.substring(1, resultString.length()-1);
        // System.out.println("<"+resultString+">");
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        sb.append(resultString);
        sb.append(">");

        System.out.println(sb);
    }
}