package November.T231123;

public class Q4Methods {
    public static int avg(int[] intNums) {
        int sum = 0;
        for (int num : intNums) {
            sum += num;
        }
        return sum / intNums.length;
    }

    public static long avg(long[] longNums) {
        long sum = 0;
        for (long num : longNums) {
            sum += num;
        }
        return sum;
    }

    public static double avg(double[] doubleNums) {
        double sum = 0;
        for (double num : doubleNums) {
            sum += num;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] intNums = {1, 2, 3};
        long[] longNums = {2, 4, 6};
        double[] doubleNums = {1, 3, 6};

        System.out.println(avg(intNums));
        System.out.println(avg(longNums));
        System.out.println(avg(doubleNums));
    }
}

