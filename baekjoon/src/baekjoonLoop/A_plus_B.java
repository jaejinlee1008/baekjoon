package baekjoonLoop;

import java.util.Scanner;

public class A_plus_B {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		int A,B;
		for(int i=0;i<num;i++)
		{
			A=scan.nextInt();
			B=scan.nextInt();
			System.out.println(A+B);
		}
	}
}
