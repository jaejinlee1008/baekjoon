package study;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class BOJ12852_0914_이재진 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();
		int[] dp = new int[X+1];
		int[] trace = new int[X+1];
		dp[X]=1;
		for(int i=X;i>0;i--) {
			if(i%3==0) {
				if(dp[i/3]==0) {
					dp[i/3]=dp[i]+1;
					trace[i/3] = i;
				}else {
					if(dp[i/3]>dp[i]+1) {
						dp[i/3] = dp[i]+1;
						trace[i/3]=i;
					}
				}
			}
			if(i%2==0) {
				if(dp[i/2]==0) {
					dp[i/2]=dp[i]+1;
					trace[i/2]=i;
				}else {
					if(dp[i/2]>dp[i]+1) {
						dp[i/2] = dp[i]+1;
						trace[i/2]=i;
					}
				}
			}
			if(dp[i-1]==0) {
				dp[i-1]=dp[i]+1;
				trace[i-1]=i;
			}else {
				if(dp[i-1]>dp[i]+1) {
					dp[i-1] = dp[i]+1;
					trace[i-1]=i;
				}
			}
			
		}
		int cur=1;
		Stack<Integer> stack = new Stack<>();
		stack.add(1);
		while(cur!=X) {
			stack.add(trace[cur]);
			cur = trace[cur];
		}
		System.out.println(dp[1]-1);
		while(!stack.isEmpty()) {
			System.out.print(stack.pop()+" ");
		}
	}
}
