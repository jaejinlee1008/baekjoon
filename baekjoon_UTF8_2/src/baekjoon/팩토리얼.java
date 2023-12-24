package baekjoon;

import java.util.Scanner;

public class 팩토리얼 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long result = 1;
		for(int i=n;i>1;i--) {
			result*=i;
		}
		System.out.println(result);
	}
}
