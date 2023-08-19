package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 알파벳 {
	
	static int R,C;
	static char[][] map;
	static int[] dx = {1,0,0,-1};
	static int[] dy = {0,1,-1,0};
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for(int i=0;i<R;i++) {
			map[i] = br.readLine().toCharArray();
		}
		DFS(0,0,new boolean[26],0);
		System.out.println(max);
	}
	private static void DFS(int x,int y,boolean[] alpha,int cnt) {
		if(alpha[map[x][y]-'A']) {
			max = Math.max(max, cnt);
			return;
		}else {
			alpha[map[x][y]-'A']=true;
			for(int i=0;i<4;i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(nx>=0&&ny>=0&&nx<R&&ny<C) {
					DFS(nx,ny,alpha,cnt+1);
				}
			}
			alpha[map[x][y]-'A']=false;
		}
	}
}
