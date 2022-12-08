package baekjoon;

import java.util.Scanner;

public class multiply {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int A, B;
		A=scan.nextInt();
		B=scan.nextInt();
		
		System.out.println(A*(B%10));
		System.out.println(A*((B%100)/10));
		System.out.println(A*(B/100));
		System.out.println(A*B);
	}
}
