package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17070_0826_이재진 {
	static int N;
	static int[][] map;
	static int cnt;
	static int[] dx= {0,1,1};
	static int[] dy= {1,0,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		boolean[][] visited = new boolean[N+1][N+1];
		for(int i=1;i<=N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==1) visited[i][j]=true; 
			}
		}
		
		dfs(1,2,0);
		System.out.println(cnt);
	}
	private static void dfs(int x,int y,int dir) {
		if(x==N&&y==N) {
			cnt++;
			return;
		}
		if(dir==0) { //파이프 현재 가로
			if(moveright(x,y)) { //가로 이동 가능한지 확인
				dfs(x,y+1,0);
			}
		}else if(dir==1) { //파이프 현재 세로
			if(movedown(x,y)) { //세로 이동 가능한지 확인
				dfs(x+1,y,1);
			}
		}else { //파이프 현재 대각선
			if(moveright(x,y)) { //가로 이동 가능한지 확인
				dfs(x,y+1,0);
			}
			if(movedown(x,y)) { 
				dfs(x+1,y,1);
			}
		}
		if(movediagonal(x,y)) {
			dfs(x+1,y+1,2);
		}
	}
	private static boolean moveright(int x,int y) {
		int nx = x;
		int ny = y+1;
		if(nx>0&&nx<=N&&ny>0&&ny<=N&&map[nx][ny]==0) {
			return true;
		}
		return false;
	}
	private static boolean movedown(int x,int y) {
		int nx = x+1;
		int ny = y;
		if(nx>0&&nx<=N&&ny>0&&ny<=N&&map[nx][ny]==0) {
			return true;
		}
		return false;
	}
	private static boolean movediagonal(int x,int y) {
		for(int i=0;i<3;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx<=0||nx>N||ny<=0||ny>N||map[nx][ny]==1) {
				return false;
			}
		}
		
		return true;
	}

}
