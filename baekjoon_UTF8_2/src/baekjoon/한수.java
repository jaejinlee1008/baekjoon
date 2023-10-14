package baekjoon;

import java.util.Scanner;

public class 한수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		if(N<100) {
			System.out.println(N);
			return;
		}
		int cnt=99;
		for(int i=100;i<=N;i++) {
			if(check(i)) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
	private static boolean check(int N) {
		char[] tmp = Integer.toString(N).toCharArray();
		if(tmp[2]-tmp[1]==tmp[1]-tmp[0]) {
			return true;
		}else {
			return false;
		}
	}
}
