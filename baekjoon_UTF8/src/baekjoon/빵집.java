package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 빵집 {
	static int R;
	static int C;
	static char[][] map;
	static int[] dx = {-1,0,1};
	static int ans;
	static boolean flag;
	static int[] output;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		output = new int[C];
		for(int i=0;i<R;i++) {
			String tmp = br.readLine();
			map[i] = tmp.toCharArray();
		}
		int j=0;
		while(!DFS(j,j,0,0,new boolean[R][C])) {
			j++;
		}
		
		System.out.println(ans);
	}
	private static boolean DFS(int first,int row,int cnt,int pick,boolean[][] visited) {
		
		return false;
	}
}
