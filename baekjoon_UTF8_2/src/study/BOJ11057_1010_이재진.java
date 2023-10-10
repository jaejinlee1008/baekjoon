package study;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ11057_1010_이재진 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long[][] dp = new long[N][11];
		for(int i=1;i<=10;i++) {
			dp[0][i]=i;
		}
		for(int i=1;i<N;i++) {
			for(int j=1;j<=10;j++) {
				for(int k=1;k<=j;k++) {
					dp[i][j] += dp[i-1][k]%10007;
				}
			}
		}
		
		System.out.println(dp[N-1][10]%10007);
	}
}
