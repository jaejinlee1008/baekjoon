package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 줄_서기 {
	static int max = 257;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][N];
		for(int i=0;i<N;i++) {
			Arrays.fill(arr[i], max);
		}
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			arr[from][to]=1;
		}
		for(int k=0;k<N;k++) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(i==j||arr[i][k]==max||arr[k][j]==max) continue;
					arr[i][j] = Math.min(arr[i][j], arr[i][k]+arr[k][j]);
				}
			}
		}
		
		for(int i=0;i<N;i++) {
			int outcnt=0;
			int incnt=0;
			for(int j=0;j<N;j++) {
				if(i==j) continue;
				if(arr[i][j]!=max&&arr[j][i]!=max) { //사이클이 있는 경우
					System.out.println(-1);
					return;
				}
				if(arr[i][j]!=max) outcnt++;
				if(arr[j][i]!=max) incnt++;
			}
			sb.append(incnt+1).append(" ").append(N-outcnt).append("\n");
		}
		System.out.println(sb);
	}
}
