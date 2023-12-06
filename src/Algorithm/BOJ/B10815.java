package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 숫자 카드의 개수 N의 개수 주어짐
        int n = Integer.parseInt(br.readLine());
        // 숫자 카드에 적혀있는 정수가 주어짐
        int[] hasNumbers = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < hasNumbers.length; i++) {
            hasNumbers[i] = Integer.parseInt(st.nextToken());
        }

        // 정렬
        Arrays.sort(hasNumbers);

        // 가지고 있는 숫자카드인지 아닌지 구해야 할 M 값
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(st.nextToken());
        }

    }

    public static boolean binarySearch(int target, int n, int[] arr) {
        int left = 0;
        int right = n -1;

        while (left <= right) {
            int mid = (right-left)/2;

            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
