package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class 나머지 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int count=0;
		int[] rest = new int[10];
		for(int i=0;i<10;i++) {
			rest[i] = scan.nextInt();
			rest[i]%=42;

		}
		int[] newarr = Arrays.stream(rest).distinct().toArray();
		System.out.println(newarr.length);
	}
}
