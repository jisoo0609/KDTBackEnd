package T231129.D8Prov;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
    Scanner와 List
    엔터로 구분된 입력이 임의의 횟수만큼 이뤄진다
    'q'가 입력되면 모든 데이터가 입력된 것이라고 생각할때
    입력했던 데이터를 순서대로 출력하시오
*/

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> strList = new ArrayList<>();
        while (sc.hasNextLine()) {
            String input = sc.nextLine();
            if ("q".equals(input)) {
                break;
            }
            strList.add(input);
        }
        // for 이용해 출력
        for (int i = 0; i <strList.size(); i++) {
            System.out.print(strList.get(i)+" ");
        }
        // for - each
        for (String input : strList) {
            System.out.print(input+" ");
        }
    }
}
