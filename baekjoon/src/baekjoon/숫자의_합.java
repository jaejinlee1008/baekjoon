package baekjoon;

import java.util.Scanner;

public class 숫자의_합 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int sum=0;
		int num = scan.nextInt();
		String str = scan.next();
		for(int i=0;i<num;i++) {
			sum+=Character.getNumericValue(str.charAt(i));
		}
		System.out.println(sum);
	}
}
