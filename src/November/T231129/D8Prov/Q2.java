package November.T231129.D8Prov;

import java.util.*;

/*
    엔터로 구분된 정수 입력이 임의의 횟수만큼 이뤄진다
    q가 입력되면 모든 데이터가 입력된 것이라고 생각할 때,
    여태까지 입력한 정수가 몇가지가 되는지 출력하시오.
    Integer.parseInt(String str)

    조건 추가 되는 경우
    + 총합
    + 정수가 아닌 입력도 받음
 */
public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Integer> intSet = new HashSet<>();
        while (sc.hasNextLine()) {
            String input = sc.nextLine();
            if ("q".equals(input)) {
                break;
            }
            intSet.add(Integer.parseInt(input));
        }

        // 정수 종류 출력하기
        // for문 이용
        int count = 0;
        for (Integer num : intSet) {
            count++;
        }
        System.out.println(count);
        //Set.size() 이용
        System.out.println("지금까지 입력한 정수의 수: "+intSet.size());
    }
}
