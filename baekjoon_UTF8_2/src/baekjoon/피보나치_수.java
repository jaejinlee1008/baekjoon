package baekjoon;

import java.util.Scanner;

public class 피보나치_수 {
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		System.out.println(fibo(0,1,0));
	}
	private static int fibo(int a,int b,int cnt) {
		if(cnt==N) {
			return a;
		}
		return fibo(b,a+b,cnt+1);
	}
}
