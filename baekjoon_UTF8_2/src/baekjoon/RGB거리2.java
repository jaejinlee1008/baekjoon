package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RGB거리2 {
	static int N;
	static long[][] input;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		input = new long[N+1][3];
		for(int i=1;i<=N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			input[i][0] = Integer.parseInt(st.nextToken());
			input[i][1] = Integer.parseInt(st.nextToken());
			input[i][2] = Integer.parseInt(st.nextToken());
		}
		long[][][][] dp = new long[N+1][3][3][2];
		long result = Long.MAX_VALUE;
		for(int i=1;i<=N;i++) {
			if(i==N) {
				if(dp[i-1][1][2][1]!=0&&dp[i-1][1][0][1]!=0) {
					result = Math.min(result,input[i][0]+Math.min(dp[i-1][1][0][0],dp[i-1][1][2][0]));
				}else if(dp[i-1][1][2][1]!=0) {
					result =  Math.min(result, input[i][0]+dp[i-1][1][2][0]);
				}else if(dp[i-1][1][0][1]!=0) {
					result = Math.min(result, input[i][0]+dp[i-1][1][0][0]);
				}
				
				if(dp[i-1][2][1][1]!=0&&dp[i-1][2][0][1]!=0) {
					result = Math.min(result, input[i][0]+Math.min(dp[i-1][2][0][0],dp[i-1][2][1][0]));
				}else if(dp[i-1][2][1][1]!=0) {
					result = Math.min(result, input[i][0]+dp[i-1][2][1][0]);
				}else if(dp[i-1][2][0][1]!=0) {
					result = Math.min(result, input[i][0]+dp[i-1][2][0][0]);
				}
				
				if(dp[i-1][0][2][1]!=1&&dp[i-1][0][1][1]!=1) {
					result = Math.min(result, input[i][1]+Math.min(dp[i-1][0][1][0],dp[i-1][0][2][0]));
				}else if(dp[i-1][0][2][1]!=1) {
					result = Math.min(result, input[i][1]+dp[i-1][0][2][0]);
				}else if(dp[i-1][0][1][1]!=1) {
					result = Math.min(result, input[i][1]+dp[i-1][0][1][0]);
				}
				
				if(dp[i-1][2][1][1]!=1&&dp[i-1][2][0][1]!=1) {
					result = Math.min(result, input[i][1]+Math.min(dp[i-1][2][0][0],dp[i-1][2][1][0]));
				}else if(dp[i-1][2][1][1]!=1) {
					result = Math.min(result, input[i][1]+dp[i-1][2][1][0]);
				}else if(dp[i-1][2][0][1]!=1) {
					result = Math.min(result, input[i][1]+dp[i-1][2][0][0]);
				}
				
				if(dp[i-1][0][2][1]!=2&&dp[i-1][0][1][1]!=2) {
					result = Math.min(result, input[i][2]+Math.min(dp[i-1][0][1][0],dp[i-1][0][2][0]));
				}else if(dp[i-1][0][2][1]!=2) {
					result = Math.min(result, input[i][2]+dp[i-1][0][2][0]);
				}else if(dp[i-1][0][1][1]!=2) {
					result = Math.min(result, input[i][2]+dp[i-1][0][1][0]);
				}
				if(dp[i-1][1][2][1]!=2&&dp[i-1][1][0][1]!=2) {
					result = Math.min(result, input[i][2]+Math.min(dp[i-1][1][0][0],dp[i-1][1][2][0]));
				}else if(dp[i-1][1][2][1]!=2) {
					result = Math.min(result, input[i][2]+dp[i-1][1][2][0]);
				}else if(dp[i-1][1][0][1]!=2) {
					result = Math.min(result, input[i][2]+dp[i-1][1][0][0]);
				}
			}else if(i==2) {
				dp[i][0][1][0] = input[i][0]+Math.min(dp[i-1][1][0][0],dp[i-1][1][2][0]);
				dp[i][0][1][1] = 1;
				dp[i][0][2][0] = input[i][0]+Math.min(dp[i-1][2][0][0],dp[i-1][2][1][0]);
				dp[i][0][2][1] = 2;
				
				dp[i][1][0][0] = input[i][1]+Math.min(dp[i-1][0][1][0],dp[i-1][0][2][0]);
				dp[i][1][0][1] = 0;
				dp[i][1][2][0] = input[i][1]+Math.min(dp[i-1][2][0][0],dp[i-1][2][1][0]);
				dp[i][1][2][1] = 2;
				
				dp[i][2][0][0] = input[i][2]+Math.min(dp[i-1][0][1][0],dp[i-1][0][2][0]);
				dp[i][2][0][1] = 0;
				dp[i][2][1][0] = input[i][2]+Math.min(dp[i-1][1][0][0],dp[i-1][1][2][0]);
				dp[i][2][1][1] = 1;
			}else {
				if(dp[i-1][1][0][0]>=dp[i-1][1][2][0]) {
					dp[i][0][1][0] = input[i][0]+dp[i-1][1][2][0];
					dp[i][0][1][1] = dp[i-1][1][2][1];
				}else {
					dp[i][0][1][0] = input[i][0]+dp[i-1][1][0][0];
					dp[i][0][1][1] = dp[i-1][1][0][1];
				}
				if(dp[i-1][2][0][0]>=dp[i-1][2][1][0]) {
					dp[i][0][2][0] = input[i][0]+dp[i-1][2][1][0];
					dp[i][0][2][1] = dp[i-1][2][1][1];
				}else {
					dp[i][0][2][0] = input[i][0]+dp[i-1][2][0][0];
					dp[i][0][2][1] = dp[i-1][2][0][1];
				}
				
				if(dp[i-1][0][1][0]>=dp[i-1][0][2][0]) {
					dp[i][1][0][0] = input[i][1]+dp[i-1][0][2][0];
					dp[i][1][0][1] = dp[i-1][0][2][1];
				}else {
					dp[i][1][0][0] = input[i][1]+dp[i-1][0][1][0];
					dp[i][1][0][1] = dp[i-1][0][1][1];
				}
				
				if(dp[i-1][2][0][0]>=dp[i-1][2][1][0]) {
					dp[i][1][2][0] = input[i][1]+dp[i-1][2][1][0];
					dp[i][1][2][1] = dp[i-1][2][1][1];
				}else {
					dp[i][1][2][0] = input[i][1]+dp[i-1][2][0][0];
					dp[i][1][2][1] = dp[i-1][2][0][1];
				}
				
				if(dp[i-1][0][1][0]>=dp[i-1][0][2][0]) {
					dp[i][2][0][0] = input[i][2]+dp[i-1][0][2][0];
					dp[i][2][0][1] = dp[i-1][0][2][1];
				}else {
					dp[i][2][0][0] = input[i][2]+dp[i-1][0][1][0];
					dp[i][2][0][1] = dp[i-1][0][1][1];
				}
				
				if(dp[i-1][1][0][0]>=dp[i-1][1][2][0]) {
					dp[i][2][1][0] = input[i][2]+dp[i-1][1][2][0];
					dp[i][2][1][1] = dp[i-1][1][2][1];	
				}else {
					dp[i][2][1][0] = input[i][2]+dp[i-1][1][0][0];
					dp[i][2][1][1] = dp[i-1][1][0][1];
				}
				
			}
		}
		System.out.println(result);
		
	}
}
