package baekjoon;

import java.util.Scanner;

public class 상수 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int A = scan.nextInt();
		int B = scan.nextInt();
		String strA = Integer.toString(A);
		String strB = Integer.toString(B);
		
		StringBuffer sb = new StringBuffer(strA);
		int reversedA = Integer.parseInt(sb.reverse().toString());
		
		sb= new StringBuffer(strB);
		int reversedB=Integer.parseInt(sb.reverse().toString());
		
		System.out.println(Math.max(reversedA, reversedB));
	}
}
