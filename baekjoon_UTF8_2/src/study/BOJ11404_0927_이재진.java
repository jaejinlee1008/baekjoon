package study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11404_0927_이재진 {
	
	static int INF = 100000000;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[][] dist = new int[N+1][N+1];
		for(int i=1;i<=N;i++) {
			Arrays.fill(dist[i], INF);
		}
		for(int i=0;i<M;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			dist[a][b] = Math.min(dist[a][b], w);
		}
		
		for(int k=1;k<=N;k++) {
			for(int i=1;i<=N;i++) {
				if(i==k) continue;
				for(int j=1;j<=N;j++) {
					if(j==k) continue;
					if(i==j) {
						dist[i][j]=0;
						continue;
					}
					if(dist[i][j]>dist[i][k]+dist[k][j]) {
						dist[i][j]=dist[i][k]+dist[k][j];
					}
				}
			}
		}
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				if(dist[i][j]==INF) {
					bw.write("0 ");
				}else {
					bw.write(dist[i][j]+" ");
				}
			}
			bw.newLine();
		}
		bw.flush();
	}
}
