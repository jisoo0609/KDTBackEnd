package T231123.D4Ex;
/*
    int[]을 두개 받아,
    두 배열이 합쳐진 배열을 반환하는 메서드를 작성하시오.
 */
public class H5Methods {
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

        for (int n : addArr(arr1, arr2)) {
            System.out.print(n+" ");
        }
    }
}
