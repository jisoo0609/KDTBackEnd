package Algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.SimpleTimeZone;
import java.util.StringTokenizer;

public class B2738 {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//
//        // 1. n과 m을 입력받음
//        int n = Integer.parseInt(st.nextToken());
//        int m = Integer.parseInt(st.nextToken());
//
//        // 2. 결과를 저장할 행렬 answer[][]와
//        // 행렬 A, B를 각각 선언한다
//        int[][] answer = new int[n][m];
//        int[][] A = new int[n][m];
//        int[][] B = new int[n][m];
//
//        // 3. 행렬 A, B에 주어진 값을 저장한다
//        for (int i = 0; i < n; i++) {
//            st = new StringTokenizer(br.readLine()," ");
//            for (int j = 0; j < m; j++) {
//                A[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//
//        for (int i = 0; i < n; i++) {
//            st = new StringTokenizer(br.readLine()," ");
//            for (int j = 0; j < m; j++) {
//                B[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//
//        // 4. 행렬 A, B의 각 값을 더하여 행렬 answer에 저장한다
//        for(int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                answer[i][j] = A[i][j] + B[i][j];
//                System.out.print(answer[i][j]+" ");
//            }
//            System.out.println();
//        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 각 행렬의 크기 정보 입력 받기
        String matInfoString = br.readLine();
        String[] matInfo = matInfoString.split(" ");
        int n = Integer.parseInt(matInfo[0]);
        int m = Integer.parseInt(matInfo[1]);

        // 행렬의 크기 정보를 바탕으로 새로운 행렬을 만들고, 할당하기
        int[][] matrix = new int[n][m];
        // 2중 반복문을 수행하면서
        for (int i = 0; i < n; i++) {
            // 각 줄을 입력받는다
            String[] rowInfo = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                // i번 줄의 j번 칸에 rowInfo[j]를 정수로 입력한다
                matrix[i][j] = Integer.parseInt(rowInfo[j]);
            }
        }

        // 1. 다른 2차원 배열을 만들어 할당 뒤 연산
        // 2. 입력을 받으며 바로 연산
        for (int i = 0; i < n; i++) {
            String[] rowInfo = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                // matrix[i][j]에 rowInfo[j]를 더함
                matrix[i][j] += Integer.parseInt(rowInfo[j]);
            }
        }

        // 출력 만들기
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i< n; i++) {
            // 각 줄 출력
            for (int j = 0; j < m; j++) {
                sb.append(matrix[i][j]);
                sb.append(" ");
            }
            System.out.println();
        }
    }
}
