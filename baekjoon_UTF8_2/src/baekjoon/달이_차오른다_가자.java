package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 달이_차오른다_가자 {
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int N,M;
	static char[][] map;
	static boolean[][][] visited;
	static int min = Integer.MAX_VALUE;
	
	static class State{
		int x,y,cnt,key;

		public State(int x, int y, int cnt, int key) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.key = key;
		}
		
	}
	static State start;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N+1][M+1];
		visited = new boolean[N+1][M+1][64];
		for(int i=1;i<=N;i++) {
			String str = br.readLine();
			for(int j=1;j<=M;j++) {
				map[i][j] = str.charAt(j-1);
				if(map[i][j]=='#') {
					for(int k=0;k<64;k++) {
						visited[i][j][k]=true;
					}
				}else if(map[i][j]=='0') {
					start = new State(i,j,0,0);
				}
			}
		}
		bfs();
		if(min==Integer.MAX_VALUE) {
			System.out.println(-1);
			return;
		}
		System.out.println(min);
	}

	private static void bfs() {
		
		Queue<State> queue = new LinkedList<>();
		queue.add(start);
		visited[start.x][start.y][start.key]= true;
		while(!queue.isEmpty()) {
			State tmp = queue.poll();
			if(map[tmp.x][tmp.y]=='1') {
				min = tmp.cnt;
				return;
			}
			for(int i=0;i<4;i++) {
				int nx = tmp.x+dx[i];
				int ny = tmp.y+dy[i];
				if(nx>=1&&nx<=N&&ny>=1&&ny<=M&&!visited[nx][ny][tmp.key]) {
					if(map[nx][ny]>='a'&&map[nx][ny]<='f') {
						int nextkey = 1<<(map[nx][ny]-'a');
						nextkey = tmp.key|nextkey;
						visited[nx][ny][nextkey]=true;
						queue.add(new State(nx,ny,tmp.cnt+1,nextkey));
					}else if(map[nx][ny]>='A'&&map[nx][ny]<='F') {
						if(1<<(map[nx][ny]-'A')==(tmp.key&1<<(map[nx][ny]-'A'))) {
							visited[nx][ny][tmp.key]=true;
							queue.add(new State(nx,ny,tmp.cnt+1,tmp.key));
						}
					}else {
						visited[nx][ny][tmp.key]=true;
						queue.add(new State(nx,ny,tmp.cnt+1,tmp.key));
					}
				}
			}
		}
		
	}
	
}
