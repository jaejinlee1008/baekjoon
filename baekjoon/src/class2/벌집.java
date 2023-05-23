package class2;

import java.util.Scanner;

public class 벌집 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int idx = 1;
		int num = 1;
		while(true) {
			if(N<=num) {
				break;
			}
			num+=6*idx;
			idx++;
		}
		System.out.println(idx);
	}
}
