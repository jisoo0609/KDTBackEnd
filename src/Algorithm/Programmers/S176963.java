package Algorithm.Programmers;

import java.util.HashMap;
import java.util.Map;

// 추억 점수
// https://school.programmers.co.kr/learn/courses/30/lessons/176963
public class S176963 {
    public static int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[1];
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }


        int[] score = new int[photo.length];

        for (int i = 0; i < photo.length; i++) {
            String[] match = photo[i];
            int sum = 0;

           for (int j = 0; j < match.length; j++) {
               String person = match[j];
               if (map.containsKey(person)) {
                   sum += map.get(person);
               }
           }
            score[i] = sum;
        }

        return score;
    }

    public static void main(String[] args) {
        String[] name = {"may", "kein", "kain", "radi"};
        int[] yearning = {5, 10, 1, 3};
        String[][] photo = {
                {"may", "kein", "kain", "radi"},
                {"may", "kein", "brin", "deny"},
                {"kon", "kain", "may", "coni"}
        };
        solution(name, yearning, photo);
    }
}
