package November.T231122.D3Ex;

import java.util.Scanner;

/*
    3명의 사람들에 대한 정보가
    개행문자로 구분된 이름(문자열)이 세번
    개행문자로 구분된 체온(정수)이 세번
    입력된다.
    이 중 체온이 38도가 넘는 사람들의 이름을 출력하도록 한다.
 */
public class H4Control {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] names = new String[3];
        int[] temperature = new int[3];

        for (int i =0; i<names.length; i++) {
            System.out.print("이릅을 입력하세요: ");
            names[i] = sc.nextLine();
        }

        for (int i=0; i<temperature.length; i++) {
            System.out.print("체온을 입력하세요: ");
            temperature[i] = sc.nextInt();
        }

        for(int i=0; i<temperature.length; i++) {
            if (temperature[i] > 38) {
                System.out.println(names[i]);
            }
        }
    }
}
