package November.T231129.D8Ex;

import java.util.*;

public class H3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<String> inputSet = new HashSet<>();

        while(sc.hasNextLine()) {
            String input = sc.nextLine();
            if ("q".equals(input))
                break;
            // 집합: 중복 허용하지 않음
            inputSet.add(input);
        }
        
        // 정렬 위해서 List로 변환
        List<String> names = new ArrayList<>(inputSet);
        Collections.sort(names);
        
        // 출력
        for (String name : names) {
            System.out.println(name);
        }
    }
}
