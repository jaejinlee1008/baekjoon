package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 쿼드트리 {
	static int N;
	static char[][] arr;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		for(int i=0;i<N;i++) {
			arr[i] = br.readLine().toCharArray();
		}
		DFS(0,0,N);
		System.out.println(sb);
	}
	
	private static void DFS(int x,int y,int len) {
//		System.out.println(x+","+y+","+len);
		if(len==1) {
			sb.append(arr[x][y]);
			return;
		}
		
		for(int i=x;i<x+len;i++) {
			for(int j=y;j<y+len;j++) {
				if(arr[i][j]!=arr[x][y]) {
					sb.append('(');
					DFS(x,y,len/2);
					DFS(x,y+len/2,len/2);
					DFS(x+len/2,y,len/2);
					DFS(x+len/2,y+len/2,len/2);
					sb.append(')');
					return;
				}
			}
		}
		sb.append(arr[x][y]);
		return;
	}
}
