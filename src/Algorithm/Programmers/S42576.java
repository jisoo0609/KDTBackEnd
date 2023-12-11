package Algorithm.Programmers;

import java.util.HashMap;
import java.util.Map;

public class S42576 {
    public String solution(String[] participant, String[] completion) {
        StringBuilder answer = new StringBuilder();

        Map<String, Integer> map = new HashMap<>();

        for (String s : participant) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        for (String c : completion) {
            map.put(c, map.get(c)-1);
        }

        for (String key : map.keySet()) {
            if (map.get(key) != 0) {
                answer.append(key);
            }
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};

        new S42576().solution(participant, completion);
    }
}
