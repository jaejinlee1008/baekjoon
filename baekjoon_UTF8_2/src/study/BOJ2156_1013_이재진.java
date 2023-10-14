package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2156_1013_이재진 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] input = new int[N+1];
		for(int i=1;i<=N;i++) {
			input[i] = Integer.parseInt(br.readLine());
		}
		int[] dp = new int[N+1];
		dp[1] = input[1];
		if(N>=2) {
			dp[2] = input[1]+input[2];
			for(int i=3;i<=N;i++) {
				dp[i] = Math.max(Math.max(dp[i-2]+input[i], dp[i-1]),dp[i-3]+input[i-1]+input[i]);
			}
		}
		System.out.println(dp[N]);
	}
}
