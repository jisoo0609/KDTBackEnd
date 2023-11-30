package November.T231128.Generic;

// <T>를 해주면 T를 타입처럼 쓸 수 있다.
public class ArrayWrapper<T extends Comparable<T>> {
    private T[] array;

    public ArrayWrapper(T[] array) {
        if (array == null)
            throw new IllegalArgumentException("null array provided");
        this.array = array;
    }

    public int length() {
        return array.length;
    }

    public boolean contains(T target) {
        for (T item : this.array) {
            if (item == null) continue; // T형이기 때문에 null인 경우도 고려 필요
            if (item.equals(target)) return true;
        }
        return false;
    }

    // 최댓값 비교
    // class이름<T extends Comparable<T>>
    // Comparable 구현 필요
    public T max() {
        T max = this.array[0];
        for (T item : this.array) {
            if (item == null) continue;
            if (max == null) max = item;
            else if (item.compareTo(max) > 0) max = item;
        }
        return max;
    }

}
