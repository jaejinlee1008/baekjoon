package baekjoon;

import java.util.Scanner;

public class N과_M_1 {
	static int N,M;
	static int[] numbers;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		numbers = new int[M];
		visited = new boolean[N+1];
		perm(0);
	}
	
	private static void perm(int cnt) {
		if(cnt==M) {
			for(int i : numbers) {
				System.out.print(i+" ");
			}
			System.out.println();
			return;
		}
		for(int i=1;i<=N;i++) {
			if(!visited[i]) {
				visited[i]=true;
				numbers[cnt]=i;
				perm(cnt+1);
				visited[i]=false;
			}
		}
	}
}
