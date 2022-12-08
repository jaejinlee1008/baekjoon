package baekjoon;

import java.util.Scanner;

public class AplusB {
	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in)) {
			int A , B;
			A = scan.nextInt();
			B = scan.nextInt();
			System.out.println(A+B);
			System.out.println(A-B);
			System.out.println(A*B);
			System.out.println(A/B);
			System.out.println(A%B);
		}
	}
}
