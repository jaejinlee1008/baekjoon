package baekjoon;

import java.util.Scanner;

public class N과_M_2 {
	static int N,M;
	static int[] numbers;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		numbers = new int[M];
		comb(0,1);
	}
	
	private static void comb(int cnt,int start) {
		if(cnt==M) {
			for(int i : numbers) {
				System.out.print(i+" ");
			}
			System.out.println();
			return;
		}
		for(int i=start;i<=N;i++) {
			numbers[cnt]=i;
			comb(cnt+1,i+1);
		}
	}
}
