package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class 최소_최대 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		int[] arr = new int[num];
		for(int i=0;i<num;i++) {
			arr[i] = scan.nextInt();
		}
		Arrays.sort(arr);
		int min = arr[0];
		int max = arr[num-1];
		System.out.println(min +" " + max);
	}
}
