package Algorithm.Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class S181894 {
    // 내 풀이
    public static int[] solution(int[] arr) {
        int left = 0;
        int right = arr.length;

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 2) {
                list.add(i);
            }
        }

        if (list.isEmpty()) {
            arr = new int[]{-1};
            return arr;
        }

        int[] index = list.stream().mapToInt(i->i).toArray();
        int start = index[0];
        int end = index[index.length - 1];

        int idx = 0;
        int[] answer = new int[end - start+1];
        for (int i = start; i <= end; i++) {
            answer[idx++] = arr[i];
        }

        return answer;
    }

    public int[] sol(int[] arr) {
        // 앞쪽 2의 위치 저장을 변수
        int front = 0;
        // 각 원소를 앞에서부터 살펴본다
        for (int i = 0; i < arr.length; i++) {
            // 2를 찾으면
            if (arr[i] == 2) {
                // 위치를 기록하고
                front = i;
                // 반복을 중단한다
                break;
            }
        }

        int back = 0;
        // 각 원소를 뒤에서부터 살펴본다
        for (int i = arr.length - 1; i > -1; i--) {
            if (arr[i] == 2) {
                back = i;
                break;
            }
        }

        // 필요한 길이의 배열을 만든다
        int[] answer = new int[back - front + 1];
        // arr[front] ~ arr[back]까지 answer에 할당한다
        for (int i = front; i < back + 1; i++) {
            answer[i - front] = arr[i];
        }
//        for (int i = 0; i < back - front; i++) {
//            answer[i] = arr[i + front];
//        }
        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 2, 1, 10, 2, 1};
        solution(arr);
    }
}
