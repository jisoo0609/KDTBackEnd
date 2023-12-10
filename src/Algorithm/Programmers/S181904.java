package Algorithm.Programmers;

// 세로 읽기
// https://school.programmers.co.kr/learn/courses/30/lessons/181904
public class S181904 {
    public String solution(String my_string, int m, int c) {
        String answer ="";
        char[][] words = new char[my_string.length()/m][m];

        int idx = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < m; j++) {
                words[i][j] = my_string.charAt(idx++);

                if (j == c-1) {
                    answer += words[i][j];
                }
                System.out.print(words[i][j]);
            }
            System.out.println();
        }

        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        new S181904().solution("ihrhbakrfpndopljhygc", 4, 2);
        new S181904().solution("programmers", 1, 1);
    }
}
