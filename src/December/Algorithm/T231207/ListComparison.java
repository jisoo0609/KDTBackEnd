package December.Algorithm.T231207;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// ArratList와 LinkedList의 상황에 따른 성능 비교
public class ListComparison {
    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<>();
        List<String> linkedList = new LinkedList<>();
        System.out.println("ArrayList 실행");
        rearInsert(arrayList);
        frontInsert(arrayList);
        getElements(arrayList);

        System.out.println("LinkedList 실행");
        rearInsert(linkedList);
        frontInsert(linkedList);
        getElements(linkedList);
    }

    // 데이터를 뒤쪽에 10000개 넣고
    public static void rearInsert(List<String> list) {
        // System.nanoTime() 메서드로 현재 시각을 10억분의 1초 단위로 반환 받는다
        long start = System.nanoTime();
        for (int i = 0; i <10000; i++) {
            list.add(0, "hello");
        }
        long end = System.nanoTime();
        System.out.println(String.format("순차적 추가 소요시간: %15d ns", end - start));
    }

    // 데이터를 앞쪽에 10000개 넣고
    public static void frontInsert(List<String> list) {
        // System.nanoTime() 메서드로 현재 시각을 10억분의 1초 단위로 반환 받는다
        long start = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            list.add(0, "hello");
        }
        long end = System.nanoTime();
        System.out.println(String.format("순차적 추가 소요시간: %15d ns", end - start));
    }


    // 각 데이터를 순서 기준으로 조회
    public static void getElements(List<String> list) {
        // System.nanoTime() 메서드로 현재 시각을 10억분의 1초 단위로 반환 받는다
        long start = System.nanoTime();
        // 각각의 데이터를 한번씩
        for (int i = 0; i < list.size(); i++) {
            list.get(i);
        }
        long end = System.nanoTime();
        System.out.println(String.format("순차적 추가 소요시간: %15d ns", end - start));
    }
}
