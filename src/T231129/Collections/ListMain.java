package T231129.Collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListMain {
    public static void main(String[] args) {
        // List는 인터페이스이다.
        // ArrayList: 배열을 관리해주는 Collection - List
        List<String> names = new ArrayList<>();
        // 리스트에 넣기
        names.add("Alex");
        names.add("Brad");
        names.add("Dave");
        names.add("Eric");
        // 데이터 회수
        System.out.println(names.get(0));
        System.out.println(names.get(2));
        // 중간에 넣기
        names.add(2, "Chad");
        System.out.println(names);
        names.add("Fred");
        // 데이터 위치 찾기
        System.out.println("Chad is at: "+names.indexOf("Chad"));
        // 없을 경우 -1
        System.out.println("Grad is at: "+names.indexOf("Grad"));
        // 데이터 제거하기
        System.out.println(names.remove(3)); // 순서를 기준으로
        System.out.println(names.remove("Eric")); // 값을 기준으로
        System.out.println(names.remove("Eric")); // 값을 기준으로 찾는데 실패

        // 원시타입 타입 파라미터로 사용 불가
        // List<int> intList = new ArrayList<>();
        // 대신 Wrapper 사용 가능
        List<Integer> intList = new ArrayList<>();
        intList.add(123);
        intList.add(10);
        intList.add(20);
        intList.add(439);
        System.out.println(intList);

        // Array
        String[] nameArray = new String[16];
        nameArray[0] = "Alex";
        nameArray[1] = "Brad";
        nameArray[2] = "Dave";
        nameArray[3] = "Eric";
        System.out.println(nameArray[0]);
        System.out.println(nameArray[2]);
        nameArray[4] = nameArray[3];
        nameArray[3] = nameArray[2];
        nameArray[2] = "Chad";

        ArrayList<Integer> intArrayList = new ArrayList<>();
        LinkedList<Integer> intLinkedList = new LinkedList<>();
        sum(intArrayList);
        sum(intLinkedList);
    }

    // 매개변수를 전달하는 기능을 중시하는 interface 기준으로 매개변수 선언
    public static int sum(List<Integer> intList) {
        return 0;
    }

    // 구현을 중시하는 방식으로 요구를 하면 기능적 측면의 차이가 없는 클래스는 사용 불가
    public static int sum(ArrayList<Integer> intList) {
        return 0;
    }
}
