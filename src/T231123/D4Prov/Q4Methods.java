package T231123.D4Prov;

public class Q4Methods {
    public static int[] reverse(int[] nums) {
        int[] reverseNum = new int[nums.length];
        for (int i=0; i<nums.length; i++) {
            reverseNum[i] = nums[nums.length-i-1];
        }
        return reverseNum;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        nums = reverse(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
