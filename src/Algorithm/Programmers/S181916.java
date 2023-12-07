package Algorithm.Programmers;

import java.util.HashMap;
import java.util.Map;

public class S181916 {
    public static String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];

        // map 이용해 플레이어와 등수 저장
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }


        // calling 배열 받으면서 map의 등수 업데이트
        for (String call : callings) {
            if (map.containsKey(call)) {
                // 현재 등수
                int now = map.get(call);
                // 바뀐 등수는 현재 등수 -1; 추월
                int update = now - 1;

                // map에서 변경
                // 불린사람은 update된 위치: 앞지른 위치
                map.put(call, update);
                // 원래 update 자리에 있던 사람이 뒤쳐진 위치(now)
                map.put(players[update], now);

                String temp = players[update];
                players[update] = players[now];
                players[now] = temp;
            }
        }

        // 업데이트 된 map 바탕으로 answer 배열 저장
        int idx = 0;
        for (String str : players) {
            answer[idx++] = str;
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};

        solution(players, callings);
    }
}
