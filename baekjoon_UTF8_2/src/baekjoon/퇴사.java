package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 퇴사 {
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[][] input = new int[N+6][2];
		int[] dp = new int[N+6];
		for(int i=1;i<=N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			input[i][0] = Integer.parseInt(st.nextToken());
			input[i][1] = Integer.parseInt(st.nextToken());
		}
		for(int i=N;i>=1;i--) {
			if(input[i][0]+i>N+1) {
				dp[i] = dp[i+1];
			}else {
				
				dp[i] = Math.max(Math.max(dp[i+1],input[i][1]+dp[i+input[i][0]]),input[i][1]);
			}
		}
		System.out.println(dp[1]);
	}
}
