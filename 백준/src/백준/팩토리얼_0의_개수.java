package 백준;

import java.util.Scanner;

public class 팩토리얼_0의_개수 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int num = scan.nextInt();
		int result = 0;
		result+=num/5;
		result+=num/25;
		result+=num/125;
		
		System.out.println(result);
		
	}
}
