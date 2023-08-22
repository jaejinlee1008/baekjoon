package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 정수_삼각형 {
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[N+1][N+1];
		for(int i=1;i<=N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1;j<=i;j++) {
				dp[i][j] = Integer.parseInt(st.nextToken());
			}
			for(int j=1;j<=i;j++) {
				dp[i][j] += Math.max(dp[i-1][j-1],dp[i-1][j]);
				max = Math.max(max, dp[i][j]);
			}
		}
		System.out.println(max);
	}
}
