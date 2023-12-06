package Algorithm.Programmers;

// 181932 코드 처리하기

import javax.print.attribute.standard.PrinterResolution;

public class S181932 {
    public static String solution(String code) {
        StringBuilder sb = new StringBuilder();

        // 1. 기본 모드 설정
        int mode = 0;

        // 2. code를 앞에서부터 읽음 for
        for (int i = 0; i< code.length(); i++) {
            // 3. 현재 문자를 가져오고
            char letter = code.charAt(i);

            // 현재 문자가 1이면 모드 변경
            if (letter == '1') {
                if (mode == 0) mode = 1;
                else mode = 0;
                // mode = mode == 0 ? 1 : 0;
            }
            // 현재 문자가 1이 아니면
            else {
                // mode가 1이고, i가 홀수이면 sb에 추가
                if (mode == 1 && i %2 == 1) {
                    sb.append(letter);
                }
                // mode가 0이고, i가 짝수이면 sb에 추가
                if (mode == 0 && i % 2 == 0) {
                    sb.append(letter);
                }

            }
        }

        // 4. 반환하고자 하는 문자열이 빈 문자열이면 EMPTY반환
        String answer = sb.toString();
        return answer.isEmpty() ? "EMPTY" : answer;
    }

    public static void main(String[] args) {
        System.out.print(solution("abc1abc1abc"));
    }
}
