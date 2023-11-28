package T231128.Generic;

public class Main {
    public static void main(String[] args) {
        Integer[] intArray = {10, 20, 30};
        ArrayWrapper<Integer> integerArrayWrapper = new ArrayWrapper<>(intArray);
        System.out.println(integerArrayWrapper.length());
        System.out.println(integerArrayWrapper.contains(10));
        System.out.println(integerArrayWrapper.contains(30));
        System.out.println(integerArrayWrapper.contains(15));

        Double[] doubleArray = {1.0, 2.3, 4.5};
        ArrayWrapper<Double> doubleArrayWrapper = new ArrayWrapper<>(doubleArray);
        System.out.println(doubleArrayWrapper.length());
        System.out.println(doubleArrayWrapper.contains(1.));
        System.out.println(doubleArrayWrapper.contains(2.31));
    }

    // 메서드에서 사용시 제어자 뒤 반환타입 전
    public static <T> boolean contains(T[] source, T target) {
        for (T item : source) {
            if (item == null) continue;
            if (item.equals(target)) return true;
        }
        return false;
    }
}
