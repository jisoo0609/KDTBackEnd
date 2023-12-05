package T231205;

import java.util.Arrays;

public class Sorting {
    // 인접한 두 원소를 비교하면서
    // 더 큰 원소를 오른쪽으로 차례대로 이동시킨다
    public static void bubbleSort(int[] array) {
        int length = array.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1; j++) {
                // j와 j+1을 비교한다
                if (array[j] > array[j+1]) {
                    // 더 크면 교환
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }

    // 가장 작은 원소를 찾아서
    // 가장 앞의 원소랑 교환하는 고정을 반복한다
    public static void selectionSort(int[] array) {
        int length = array.length;

        for (int j = 0; j < length -1; j++) {
            // 현재 정렬되지 않은 제일 앞쪽 인덱스
            int minIndex = 0;
            // array 원소 중 최솟값이 어디있는지를 찾는다
            for (int i = 0; i < length; i++) {
                if (array[i] < array[minIndex]) {
                    minIndex = i;
                }
            }
            // 제일 작은 원소와 제일 앞의 원소를 교환한다
            int temp = array[minIndex];
            array[minIndex] = array[j];
            array[j] = temp;
        }
    }

    public static void countingSort(int[] array) {
        // 원래는 max를 찾아야 하는데
        // 이번만큼은 5임을 알고있다 가정
        // 정수 배열 초기화 -> 초기값 0인 배열 만들어짐
        int[] counts = new int[6];
        // 모든 array 데이터를 순회하면서 각 counts[data]++;
        for (int data : array) {
            counts[data]++;
        }
        // counts 배열을 각 데이터가 마지막에 나오는 위치에 담기게 배열
        for (int i = 0; i < 5; i++) {
            // 다음칸에 지금칸의 데이터를 담아준다
            counts[i+1] += counts[i];
        }
        // counts 배열 중간출력
        System.out.println("counts: "+Arrays.toString(counts));

        // 결과를 담을 배열 만들기(output)
        int[] output = new int[array.length];
        // 뒤에서부터 순회하며 output 배열 채우기
        for (int i = array.length -1; i >= 0; i--) {
            // 현재 원소의 마지막 위치를 조정
            counts[array[i]]--;
            // 현재 데이터의 다음 위치 정보를 회수
            int position = counts[array[i]];
            // 새로운 배열의 position에 데이터 넣기
            output[position] = array[i];
        }

        // 원본에 새로운 데이터 적용하기
        for (int i = 0; i < array.length; i++) {
            array[i] = output[i];
        }
    }

    public static int binarySearch(int[] array, int target) {
        // 검색 대상 경계선을 세운다
        // 배열의 시작과 끝의 인덱스를 지정한다
        int left = 0;
        int right = array.length - 1;

        // 왼쪽이 오른쪽보다 작거나 같은 경우 계속 반복
        while (left <= right) {
            // 중간지점 설정 (왼쪽부터 오른쪽 까지의 거리만큼 왼쪽에서 이동한 정도)
            int mid = (right - left) / 2;

            // 3단계
            // 1. 가운데에 원하는것이 있었다
            if (array[mid] == target) {
                return mid;
            }
            // 2. 가운데가 원하는 것보다 작다
            // target이 지금보다 오른쪽에 존재
            else if (array[mid] < target) {
                // left 조정해줌
                left = mid + 1;
            }
            // 3. 가운데가 원하는 것보다 크다
            else {
                // right 조정함
                right = mid - 1;
            }
        }
        // 탐색에 실패했다면, 그걸 표시하기 위한 값을 반환
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {36, 12, 18, 15, 41, 19};
        array = new int[]{11, 31, 29, 16, 20, 1, 5, 8};
        System.out.println("initial: " + Arrays.toString(array));
//        Arrays.sort(array);
        // bubbleSort(array);
        selectionSort(array);
        System.out.println(Arrays.toString(array));

        array = new int[]{11, 31, 29, 16, 20, 1, 5, 8};
        System.out.println(binarySearch(array, 5));

        array = new int[]{0, 1, 4, 4, 3, 0, 5, 2, 5, 1};
        countingSort(array);
        System.out.println(Arrays.toString(array));
    }
}
