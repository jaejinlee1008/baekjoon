package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 배열_돌리기1 {
	static int N;
	static int M;
	static int R;
	static int min;
	static int[][] arr;
	static int[] dx = {0,1,0,-1}; //우상좌하
	static int[] dy = {1,0,-1,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		min = Math.min(N, M)/2;
		for(int i=0;i<R;i++) {
			rotate();
		}
		
		for(int[] ar : arr) {
			System.out.println(Arrays.toString(ar).substring(1,Arrays.toString(ar).length()-1).replace(",", ""));
		}
	}
	private static void rotate() {
		for(int i=0;i<min;i++) {
			int x=i;
			int y=i;
			int value = arr[x][y];
			int idx=0;
			while(idx<4) {
				int nx = x+dx[idx];
				int ny = y+dy[idx];
				if(nx>=i&&nx<N-i&&ny>=i&&ny<M-i) {
					arr[x][y]=arr[nx][ny];
					x=nx;
					y=ny;
				}else {
					idx++;
				}
			}
			arr[i+1][i]=value;
		}
		
	}
}
