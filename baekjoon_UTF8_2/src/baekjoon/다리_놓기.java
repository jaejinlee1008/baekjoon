package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 다리_놓기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i=1;i<=T;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int[][] B = new int[N+1][K+1];
			
			for(int j=0;j<=N;j++) {
				for(int k=0,end=Math.min(j, K);k<=end;k++) {
					if(k==0||j==k) B[j][k]=1;
					else B[j][k] = B[j-1][k-1] + B[j-1][k];
				}
			}
			System.out.println(B[N][K]);
		}
	}
}
