package T231120;

import java.io.IOException;
import java.util.Scanner;

public class Q4VarAndTypes {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("시간을 입력하세요: ");
		int time = sc.nextInt();
		
		System.out.print("오전 또는 오후를 입력하세요: ");
		String st = sc.next();
		
		if(!(st.equals("오전")||st.equals("오후"))) {
			throw new IOException("잘못된 문자를 입력하셨습니다");
		}
		
		System.out.print(st+" "+time+"시");
		// System.out.print(String.formating("%s %d시", amPm, time));
	}
}
