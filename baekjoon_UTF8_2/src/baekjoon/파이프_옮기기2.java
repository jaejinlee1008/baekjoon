package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 파이프_옮기기2 {
	static int N;
	static long[][][] dp;
	static int[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new long[N+1][N+1][3];// 가로,세로,대각선
		map = new int[N+1][N+1];
		for(int i=1;i<=N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++) {
				int num = Integer.parseInt(st.nextToken());
				map[i][j]=num;
			}
		}
		if(map[N][N]==1) {
			System.out.println(0);
			return;
		}
		
		dp[1][2][0]=1;
		
		for(int i=1;i<=N;i++) {
			for(int j=3;j<=N;j++) {
				if(map[i][j]==1) continue;
				dp[i][j][0] = dp[i][j-1][0]+dp[i][j-1][2];
				if(i==1) continue;
				dp[i][j][1] = dp[i-1][j][1]+dp[i-1][j][2];
				if(map[i-1][j]==1||map[i][j-1]==1) continue;
				dp[i][j][2] = dp[i-1][j-1][0]+dp[i-1][j-1][1]+dp[i-1][j-1][2];
			}
		}
		System.out.println(dp[N][N][0]+dp[N][N][1]+dp[N][N][2]);
	}
	
	
}
