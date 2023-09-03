package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 평범한_배낭 {
	static class Item{
		int W;
		int V;
		
		public Item(int w, int v) {
			super();
			W = w;
			V = v;
		}
		
	}
	static int[][] item;
	static int[][] dp;
	static int N,K;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		item = new int[N+1][K+1];
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine().trim());
			item[i][0]=Integer.parseInt(st.nextToken());
			item[i][1] = Integer.parseInt(st.nextToken());
		}
		dp = new int[N+1][K+1];
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=K;j++) {
				dp[i][j]=dp[i-1][j];
				if(j-item[i][0]>=0) {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-item[i][0]]+item[i][1]);
				}
			}
		}
		
		
		System.out.println(dp[N][K]);
	}
	
}
