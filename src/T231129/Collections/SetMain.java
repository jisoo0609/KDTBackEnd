package T231129.Collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Set
// 순서 X, 중복 허용 X
public class SetMain {
    public static void main(String[] args) {
        Set<String> skilSet =new HashSet<>();
        // add를 사용해 원소 추가하는 것 동일
        skilSet.add("md");
        skilSet.add("git");
        skilSet.add("java");
        skilSet.add("oop");
        // 중복되는 데이터는 추가 X
        skilSet.add("java");
        // 데이터의 순서를 보장하지 않음
        System.out.println(skilSet);

        List<String> skillList = new ArrayList<>();
        skillList.add("java");
        skillList.add("kotlin");
        skillList.add("android");
        skillList.add("flutter");
        skillList.add("react");
        skillList.add("git");
        // 다른 Collection의 원소를 전부 추가 시도
        // 내가 없는 원소를 선발해 추가한다
        // 하나라도 추가하면 true
        System.out.println(skillList); // true
        System.out.println(skilSet.addAll(skillList));
        System.out.println(skilSet);

        // 비둘기집 원리
        List<Pigeon> listHoles = new ArrayList<>();
        Set<Pigeon> setHoles = new HashSet<>();

        for (int i = 0; i < 20; i++) {
            Pigeon pigeon = new Pigeon(i%10);
            listHoles.add(pigeon);
            setHoles.add(pigeon);
        }
        System.out.println("list pigeon: "+listHoles.size());
        System.out.println("set pigeon: "+setHoles.size());

        List<String> thirdSkills = new ArrayList<>();
        thirdSkills.add("javascript");
        thirdSkills.add("typescript");
        thirdSkills.add("python");
        thirdSkills.add("java");
        // 아이템 제거하기
        thirdSkills.remove("typescript");
        System.out.println(skilSet.removeAll(thirdSkills));
    }
}
