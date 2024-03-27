package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 로봇_청소기 {
	static int N,M;
	static int startx,starty;
	static int d;
	static int[][] room;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		startx = Integer.parseInt(st.nextToken());
		starty = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		room = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
}
