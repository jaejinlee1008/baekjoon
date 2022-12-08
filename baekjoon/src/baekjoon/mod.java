package baekjoon;

import java.util.Scanner;

public class mod {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int A, B, C;
		
		A=scan.nextInt();
		B=scan.nextInt();
		C=scan.nextInt();
		
		System.out.println((A+B)%C);
		System.out.println(((A%C)+(B%C))%C);
		System.out.println((A*B)%C);
		System.out.println(((A%C)*(B%C))%C);
			
		
	}
}
