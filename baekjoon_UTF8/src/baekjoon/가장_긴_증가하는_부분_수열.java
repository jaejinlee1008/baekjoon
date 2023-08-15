package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장_긴_증가하는_부분_수열 {
	static int N;
	static int[] input;
	static int[] dp;
	static int answer = Integer.MIN_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		input = new int[N+1];
		int min=Integer.MAX_VALUE;
		for(int i=1;i<=N;i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		dp = new int[N+1];
		dp[1] = 1;
		min = 1;
		if(N==1) {
			System.out.println("1");
			return;
		}
		for(int i=2;i<=N;i++) {
			int max=0;
			for(int j=1;j<i;j++) {
				if(input[j]<input[i]) {
					max = Math.max(max,dp[j]);
				}
			}
			dp[i]=max+1;
			answer = Math.max(answer, dp[i]);
		}
		System.out.println(answer);
	}

}
