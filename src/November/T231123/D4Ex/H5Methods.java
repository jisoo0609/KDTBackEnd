package November.T231123.D4Ex;
/*
    int[]을 두개 받아,
    두 배열이 합쳐진 배열을 반환하는 메서드를 작성하시오.
 */
public class H5Methods {


    // 2. for i를 두번 돌되, 두번째 할때는 위치를 +front.length
    // 3. 한번에 하는 방법
    public static int[] addArr1(int[] front, int[] back) {
        int[] result = new int[front.length+back.length];
        // 1. 외부에 result 원소 순서를 만들어 for 두번
        int idx = 0;
        for (int i =0; i < front.length; i++) {
            result[idx] = front[i];
            idx++;
        }
        for (int i =0; i<back.length; i++) {
            result[idx] = front[i];
            idx++;
        }
        return result;
    }

    public static int[] addArr(int[] arr1, int[] arr2) {
        int[] arrAdd = new int[arr1.length+arr2.length];

        for (int i=0; i<arr1.length; i++) {
            arrAdd[i] = arr1[i];
        }

        int idx=0;
        for (int i=arr1.length; i<arrAdd.length; i++) {
            arrAdd[i] = arr2[idx++];
        }
        return arrAdd;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 8, 5, 7, 6};
        int[] arr2 = {4, 6, 7, 3, 2};

        for (int n : addArr1(arr1, arr2)) {
            System.out.print(n+" ");
        }
    }
}
