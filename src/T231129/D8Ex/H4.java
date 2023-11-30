package T231129.D8Ex;

import java.util.*;

public class H4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, List<String>> majorStudents = new HashMap<>();

        while (sc.hasNextLine()) {
            // '전공 이름' 입력받음
            String input = sc.nextLine();
            String[] str = input.split(" ");

            if ("q".equals(input)) {
                break;
            }
            // putIfAbsent 이용
            // 키가 존재하지 않을 때 새로운 값이 추가되면 null 반환
            // 키가 이미 존재해서 새로운 값이 추가되지 않았다면, 기존 값 반환
            List<String> before = majorStudents.putIfAbsent(str[0], new ArrayList<>());
            if (before != null) {
                majorStudents.put(str[0], before);
            }

            // 값 추가
            // Value 값 List 형태로 받아야 하기 때문에
            // majorStudents에서 이름을 기준으로 리스트를 가져와
            // Studnetlist를 만들고
            // 입력받은 전공인 str[1]을 list에 추가함
            List<String> studentsList = majorStudents.get(str[0]);
            studentsList.add(str[1]);
        }
        System.out.println(majorStudents);
    }
}
