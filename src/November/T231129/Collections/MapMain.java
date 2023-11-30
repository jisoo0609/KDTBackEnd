package November.T231129.Collections;

import java.util.*;

// Key - Values
// 순서 중요하지 않음
public class MapMain {
    public static void main(String[] args) {
        // 핸드폰 - 연락처
        // 연락처를 검색하는 기준
        // 이름 - 전화번호
        // 메뉴 - 가격 / 이름 - 성적 / 전공 - 전공생들 등
        // git config user.email - 이메일
        // git config user.name - 아이디
        Map<String, String> contactBook = new HashMap<>();
        // Map에 연락처 저장
        contactBook.put("Alex", "010-1234-5678");
        contactBook.put("Brad", "010-9876-5432");
        contactBook.put("Chad", "010-0110-0000");
        contactBook.put("Eric", "010-2222-2222");

        // Map에서 연락처 찾아오기
        System.out.println(contactBook.get("Alex"));
        System.out.println(contactBook.get("Chad"));
        System.out.println(contactBook.get("Brad"));
        // 1. 없는걸 가져올때는 null이 된다
        System.out.println(contactBook.get("Dave"));
        // 2. 있는걸 추가할때는 덮어씌운다
        contactBook.put("Eric", "010-2555-5555");

        // 전공생 수
        // CSE - 10
        // EE - 20
        // ME - 15
        // BA - 30
        Map<String, Integer> majorMember = new HashMap<>();
        majorMember.put("CSE", 10);
        majorMember.put("EE", 20);
        majorMember.put("ME", 15);
        majorMember.put("BA", 30);
        System.out.println(majorMember);

        // 만약 데이터를 넣어야 하는 상황에 새로운 전공이 생긴다면?
        // 1. majorMember.get("major") == null
        String newMajor = "ENG";
        if (majorMember.get(newMajor) == null) {
            majorMember.put(newMajor, 1);
        } else {
            int before = majorMember.get(newMajor);
            majorMember.put(newMajor, before+1);
        }

        // 2. putIfAbsent
        // 지정된 키가 아직 값과 연결되지 않은 경우(또는 null에 매핑된 경우)
        // 키가 존재하지 않을때 새로운 값이 추가되면 null을 반환
        // 키가 이미 존재해서 새로운 값이 추가되지 않았다면, 기존 값이 반환
        Integer before = majorMember.putIfAbsent(newMajor, 1);
        if (before != null) {
            majorMember.put(newMajor, before+1);
        }
        System.out.println(majorMember);

        Map<String, List<String>> majorStudents = new HashMap<>();
        majorStudents.put("CSE", new ArrayList<>());
        List<String> cseStudnets = majorStudents.get("CSE");
        cseStudnets.add("Alex");
        cseStudnets.add("Brad");
        cseStudnets.add("Chad");
        System.out.println(majorStudents);

        // KeySet, entrySet()
        // Map을 순회하고 싶으면 둘 중 하나를 선택할 수 있다

        // KeySet()
        // 이름을 기준으로 연락처를 가지고 오는 것 선택 가능
        Set<String> KeySet = contactBook.keySet();
        for (String key : contactBook.keySet()) {
            System.out.println(key);
            // Key로만 구성되어있는 집합 불러옴
            System.out.println(contactBook.get(key));
        }

        // entrySet() - Key - Value 쌍으로 구성된 Set
        for (Map.Entry<String, String> entry : contactBook.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

    }
}
