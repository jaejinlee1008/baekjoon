package baek;

import java.util.Scanner;

public class _2xn_Ÿ�ϸ�2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] dp = new int[n+1];
		dp[0]=0;
		dp[1]=1;
		
		if(n>1) {
			dp[2]=3;
			for(int i=3;i<=n;i++) {
				dp[i]=(dp[i-1]+(dp[i-2])*2)%10007;
			}
		}
		System.out.println(dp[n]%10007);
	}
}
