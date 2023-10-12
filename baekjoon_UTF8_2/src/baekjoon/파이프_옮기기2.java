package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 파이프_옮기기2 {
	static int N;
	static int[][][] arr;
	static boolean[][] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1][N+1][3];// 가로,세로,대각선
		visited = new boolean[N+1][N+1];
		for(int i=1;i<=N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++) {
				int num = Integer.parseInt(st.nextToken());
				if(num==1) visited[i][j]=true;
				for(int k=0;k<3;k++) {
					arr[i][j][k]=num;
				}
			}
		}
		arr[1][1][0]=1;
		arr[1][2][0]=1;
		arr[1][1][1]=1;
		arr[1][2][1]=1;
		arr[1][1][2]=1;
		arr[1][2][2]=1;
		
		for(int i=1;i<=N;i++) {
			for(int j=2;j<=N;j++) {
				if(arr[i][j][0])
				arr[i][j][0] = arr[i][j-1][0]+arr[i][j-1][2];
				arr[i][j][1] = arr[i-1][j][1]+arr[i-1][j][2];
				arr[i][j][2] = arr[i-1][j-1][0]+arr[i-1][j-1][1]+arr[i-1][j-1][2];
			}
		}
		System.out.println(arr[N][N][0]+arr[N][N][1]+arr[N][N][2]);
	}
	
	private static boolean check() {
		
	}
}
