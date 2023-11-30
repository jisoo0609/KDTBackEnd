package November.T231120.D1Prov;

import java.io.IOException;
import java.util.Scanner;

public class Q5VarAndTypes {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		double[] score = new double[3];
		String[] name = new String[3];
		
		for(int i=0; i<name.length; i++) {
			System.out.print("이름과 학점을 입력하세요: ");
			score[i] = sc.nextDouble();
			if(score[i] < 0.0 || score[i]>4.5) {
				throw new IOException("잘못된 범위의 실수를 입력했습니다.");
			}
			name[i] = sc.next();
		}
		
		for(int i=0; i<name.length; i++) {
			System.out.println("이름 - <"+name[i]+">, 학점 - <"+score[i]+">");
		}
	}

}
