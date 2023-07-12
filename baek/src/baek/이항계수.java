package baek;

import java.util.Scanner;

public class 이항계수 {
	public static int[][] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int r = sc.nextInt();
		dp=new int[n+1][n+1];
		binomial(n,r);
		System.out.println(dp[n][r]);
	}
	public static void binomial(int n, int r) {
		for(int i=0;i<=n;i++) {
			for(int j=0;j<=Math.min(i, r);j++) {
				if(j==0||j==i) {
					dp[i][j]=1;
				}else {
					dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
				}
			}
		}
	}
}
