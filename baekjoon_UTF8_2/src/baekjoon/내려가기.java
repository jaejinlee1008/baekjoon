package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 내려가기 {
	static int N;
	static int[][] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1][3];
		for(int i=1;i<=N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[][] dpmax = new int[N+1][3];
		for(int i=1;i<=N;i++) {
			dpmax[i][0] = arr[i][0] + Math.max(dpmax[i-1][0],dpmax[i-1][1]);
			dpmax[i][1] = arr[i][1] +  Math.max(dpmax[i-1][0], Math.max(dpmax[i-1][1], dpmax[i-1][2]));
			dpmax[i][2] = arr[i][2] +  Math.max(dpmax[i-1][1], dpmax[i-1][2]);
		}
		int max = Integer.MIN_VALUE;
		for(int i=0;i<3;i++) {
			max = Math.max(max, dpmax[N][i]);
		}
		System.out.print(max+" ");
		
		int[][] dpmin = new int[N+1][3];
		for(int i=1;i<=N;i++) {
			dpmin[i][0] = arr[i][0] + Math.min(dpmin[i-1][0],dpmin[i-1][1]);
			dpmin[i][1] = arr[i][1] +  Math.min(dpmin[i-1][0], Math.min(dpmin[i-1][1], dpmin[i-1][2]));
			dpmin[i][2] = arr[i][2] +  Math.min(dpmin[i-1][1], dpmin[i-1][2]);
		}
		int min = Integer.MAX_VALUE;
		for(int i=0;i<3;i++) {
			min = Math.min(min, dpmin[N][i]);
		}
		System.out.print(min);
	}
}
