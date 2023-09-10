package baekjoon;

import java.util.Scanner;

public class 수들의_합 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long S = sc.nextLong();
		int i=1;
		int cnt=0;
		while(i<=S) {
			S-=i;
			i++;
			cnt++;
		}
		System.out.println(cnt);
	}
}
