package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 계단_오르기 {
	
	static int N;
	static int[] arr;
	static int[] dp;
	static int SUM=Integer.MIN_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		dp = new int[N+1];
		for(int i=1;i<=N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		dp[1]=arr[1];
		if(N>=2) {
			dp[2] = arr[1]+arr[2];
		}
		if(N>=3) {
			for(int i=3;i<=N;i++) {
				dp[i] = arr[i] + Math.max(arr[i-1]+dp[i-3], dp[i-2]);
			}
		}
		System.out.println(dp[N]);
	}
	
	
}
