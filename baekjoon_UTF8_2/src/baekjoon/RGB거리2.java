package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RGB거리2 {
	static int N;
	static int[][] input;
	static int[][] dp;
	static int INF = 1000*1000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		input = new int[N+1][3];
		dp = new int[N+1][3];
		for(int i=1;i<=N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			input[i][0] = Integer.parseInt(st.nextToken());
			input[i][1] = Integer.parseInt(st.nextToken());
			input[i][2] = Integer.parseInt(st.nextToken());
		}
		int result = INF;
		for(int k=0;k<3;k++) {
			for(int i=0;i<3;i++) {
				if(i==k) dp[1][i] = input[1][i];
				else {
					dp[1][i] = INF;
				}
			}
			
			for(int i=2;i<=N;i++) {
				dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2])+input[i][0];
				dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2])+input[i][1];
				dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1])+input[i][2];
			}
			
			for(int i=0;i<3;i++) {
				if(i!=k) result = Math.min(result, dp[N][i]);
			}
		}
		System.out.println(result);
	}
}
