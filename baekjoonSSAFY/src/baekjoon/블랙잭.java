package baekjoon;

import java.util.Scanner;

public class ∫Ì∑¢¿Ë {
	
	public static int max = Integer.MIN_VALUE;
	public static int M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int len = sc.nextInt();
		M = sc.nextInt();
		int[] arr = new int[len];
		for(int i=0;i<len;i++) {
			arr[i] = sc.nextInt();
		}
		boolean[] visited = new boolean[len];
		comb(arr,visited,0,0,3);
		System.out.println(max);
	}
	public static void comb(int[] arr,boolean[] visited,int start, int depth, int r) {
		if(depth==r) {
			int sum=0;
			for(int i=0;i<arr.length;i++) {
				if(visited[i]) {
					sum+=arr[i];
				}
			}
			if(sum<=M) {
				max = Math.max(max, sum);
			}
			return;
		}
		for(int i=start;i<arr.length;i++) {
			if(!visited[i]) {
				visited[i]=true;
				comb(arr,visited,i+1,depth+1,r);
				visited[i]=false;
			}
		}
	}
}
