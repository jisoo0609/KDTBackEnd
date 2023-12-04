package T231204.Programmers;

public class S181883 {
    public int[] solution(int[] arr, int[][] queries) {
        // queries 배열의 i와 같은 arr의 인덱스에 위치한 값을 1씩 증가
        for (int i = 0; i < queries.length; i++) {
            int s = queries[i][0];
            int e = queries[i][1];

            for (int j = s; j <= e; j++) {
                arr[j] += 1;
            }
        }
        return arr;
    }

    public static void main(String[] args) {


    }
}
