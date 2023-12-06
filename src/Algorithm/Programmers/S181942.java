package Algorithm.Programmers;

public class S181942 {
    public String Solution1(String str1, String str2) {
        String answer = "";
        // String.toCharArray()
        // 문자열을 구하는 char의 배열을 반환하는 메서드
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        // 1. str1의 길이만큼 반복한다
        for (int i = 0; i < str1.length(); i++) {
            // 2. str1의 i번째 글자를 answer에 덧붙인다
            answer += chars1[i];
            // 3. str2의 i번째 글자를 answer에 덧붙인다
            answer += chars2[i];
        }
        return answer;
    }

    public String Solution2(String str1, String str2) {
        String answer = "";
        // String.charAt()
        // 문자열을 구성하는 char들 중 indext번째를 반환
        for (int i = 0; i <str1.length(); i++) {
            answer += str1.charAt(i);
            answer += str2.charAt(i);
        }
        return answer;
    }

    public String Solution3(String str1, String str2) {
        String answer = "";
        // StringBuilder로 답을 작성하기
        StringBuilder sb = new StringBuilder();
        for (int i =0; i < str1.length(); i++) {
            // 정답 문자열 뒤에 붙이고 싶은 데이터를
            // append 메서드로 전달
            sb.append(str1.charAt(i));
            sb.append(str2.charAt(i));
        }
        answer = sb.toString();
        return answer;
    }
}
