package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 상자넣기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n+1];
		
		for(int i=1;i<=n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int[] dp = new int[n+1];
		int max = Integer.MIN_VALUE;
		Arrays.fill(dp, 1);
		for(int i=2;i<=n;i++) {
			for(int j=1;j<i;j++) {
				if(arr[i]>arr[j]) {
					dp[i] = Math.max(dp[j]+1,dp[i]);
				}
			}
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}
}
