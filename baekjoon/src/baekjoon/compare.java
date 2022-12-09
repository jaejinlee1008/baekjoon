package baekjoon;

import java.util.Scanner;

public class compare {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int A, B;
		
		A = scan.nextInt();
		B = scan.nextInt();
		
		if(A>B)
		{
			System.out.println(">");
		}else if(A<B) {
			System.out.println("<");
		}else if(A==B)
		{
			System.out.println("==");
		}
	}
}
