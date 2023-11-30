package November.T231129.Collections;

import java.util.*;

public class IterableMain {
    public static void main(String[] args) {
        // Iterable / Collection / List / Set
        // 전부 순회 가능
        // List와 Set 모두 Iterable. 서로 바꾸기 가능
        List<String> skillList = new ArrayList<>();
        skillList.add("java");
        skillList.add("git");
        skillList.add("md");
        skillList.add("python");
        skillList.add("aws");
        skillList.add("linux");

        for (String skill : skillList) {
            System.out.println(skill);
            // 예외발생. ConcurrentModificationException
            // for-each를 이용한 제거 불가능
            // skillList.remove("python");
        }

        // Iterator
        Iterator<String> iter = skillList.iterator();
        // 다음 대상이 있는지 판단
        while (iter.hasNext()) {
            // next()를 이용해 다음에 있는 data 가져옴
            String skill = iter.next();
            System.out.println(skill);
            // iter.remove()를 사용하면 안전하게 순회 중 제거 가능
            if ("python".equals(skill))
                iter.remove();
        }
        System.out.println(skillList);

        // Collection
        List<String> listCollection = new ArrayList<>();
        Set<String> setCollection = new HashSet<>();

        // List의 Collection 메서드
        System.out.println(listCollection.size());
        System.out.println(listCollection.isEmpty());
        System.out.println(listCollection.contains(""));
        System.out.println(listCollection.containsAll(setCollection));
        // Set의 Collection 메서드
        System.out.println(setCollection.size());
        System.out.println(setCollection.isEmpty());
        System.out.println(setCollection.contains(""));
        System.out.println(setCollection.containsAll(listCollection));

        // Collection의 문서를 보면
        // Collection 인터페이스를 구현하는 클래스는
        // 1. 아무것도 없는 기본 생성자
        // 2. 다른 Collection을 받아 그 모든 원소를 가지는 생성자
        // 만들어 마땅하다
    }
}
