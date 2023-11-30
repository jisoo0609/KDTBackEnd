package November.T231128.Generic;

/*
    정수 배열을 가지고 있고,
    그 정수 배열에 대한 정보를 제공하는 목적의 배열 편의성 클래스
 */
public class intArrayWrapper {
    private final int[] intArray;

    public intArrayWrapper(int[] intArray) {
        this.intArray = intArray;
    }

    // 1. intArray의 길이를 반환하는 메서드
    public int length() {
        return this.intArray.length;
    }

    // 2. 주어진 int target이 intArray에 존재하는지 반환하는 메서드(boolean)
    public boolean isTarget(int target) {
        for (int n : this.intArray) {
            if (target == n) return true;
        }
        return false;
    }

    // 3. intArray의 원소 중 최댓값
    public int max(int[] intArray) {
        int max = this.intArray[0];
        for(int n : this.intArray) {
            // Math : 여러 수학 작업이 존재하는 클래스
            max = Math.max(n, max);
        }
        
        return max;
    }
}
