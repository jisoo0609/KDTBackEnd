package November.T231123.D4Ex;
/*
    int[]을 인자로 받아,

    배열의 값들 중 최댓값의 위치를 반환하는 "maxWhere"
    배열의 값들 중 최솟값의 위치를 반환하는 "minWhere"
    배열의 값들 중 최댓값과 최솟값의 차이를 반환하는 "maxDiff"

    메서드를 각각 작성하시오.
 */
public class H4Methods {
    // 배열의 값들 중 최댓값의 위치를 반환
    public static int maxWhere(int[] nums) {
        // 초기 비교 대상
        int max = nums[0];
        int idx = 0;

        for (int i=0; i<nums.length; i++) {
            if(nums[i] > max){
                max = nums[i];
                idx = i;
            }
        }
        return idx;
    }

    // 배열의 값들 중 최솟값의 위치를 반환하는
    public static int minWhere(int[] nums) {
        int min = nums[0];
        int idx = 0;

        for (int i=0; i<nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
                idx = i;
            }
        }
        return idx;
    }

    // 배열의 값들 중 최댓값과 최솟값의 차이를 반환하는
    public static int maxDiff(int[] nums) {
        int maxIdx = maxWhere(nums);
        int minIdx = minWhere(nums);

        return maxIdx - minIdx;
    }

    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 1, 6, 8};
        System.out.println(String.format("최댓값의 위치: (index) %d", maxWhere(nums)));
        System.out.println(String.format("최솟값의 위치: (index) %d", minWhere(nums)));
        System.out.println(String.format("최댓값과 최솟값의 차이: %d", maxDiff(nums)));
    }
}
