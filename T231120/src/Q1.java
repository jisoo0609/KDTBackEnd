/* 사용자에게 입력을 받고,
 * 동일한 내용을 세번 출력하는 코드를 작성하시오.
 */

import java.util.Scanner;

public class Q1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		for(int i=0; i<3; i++) {
			System.out.println(str);
		}
	}

}
