package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 가장_긴_증가하는_부분_수열 {
	static int N;
	static int[] input;
	static int[] dp;
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
			for(int j=3;j<=N;j++) {
				
			}
		}
	}

}
