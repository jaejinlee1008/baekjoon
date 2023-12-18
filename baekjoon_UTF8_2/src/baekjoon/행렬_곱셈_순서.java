package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 행렬_곱셈_순서 {
	static int N;
	static int[][] input;
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		input = new int[N][2];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			input[i][0]=r;
			input[i][1]=c;
		}
		dp = new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(i==j)
					dp[i][j]=0;
				else
					dp[i][j] = Integer.MAX_VALUE;
			}
		}
		for(int c=1;c<N;c++) {
			for(int i=0;i+c<N;i++) {
				calc(i,i+c);
			}
		}
		System.out.println(dp[0][N-1]);
		
	}
	private static void calc(int start,int end) {
		for(int i=start;i<end;i++) {
			int cost = dp[start][i]+dp[i+1][end]+input[start][0]*input[i][1]*input[end][1];
			dp[start][end] = Math.min(dp[start][end], cost);
		}
	}
}
