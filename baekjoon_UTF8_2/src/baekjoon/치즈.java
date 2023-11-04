package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 치즈 {
	static int N,M;
	static int[][] map;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int cheese=0;
	static int cnt=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N+1][M+1];
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1) {
					cheese++;
				}
			}
		}
		while(cheese>0) {
			setmap();
			cnt++;
//			for(int[] ar : map) {
//				System.out.println(Arrays.toString(ar));
//			}
		}
		System.out.println(cnt);
		
	}
	private static void setmap() {
		boolean[][] visited = new boolean[N+1][M+1];
		List<int[]> destroy = bfs(1,1,visited);
		for(int[] pos : destroy) {
			map[pos[0]][pos[1]]=0;
			cheese--;
		}
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=M;j++) {
				if(map[i][j]>=1) {
					map[i][j]=1;
				}
			}
		}
	}
	private static List<int[]> bfs(int x, int y,boolean[][] visited) {
		Queue<int[]> queue = new LinkedList<>();
		List<int[]> destroy = new ArrayList<>();
		queue.add(new int[] {x,y});
		visited[x][y]=true;
		while(!queue.isEmpty()) {
			int[] tmp = queue.poll();
			for(int i=0;i<4;i++) {
				int nx = tmp[0]+dx[i];
				int ny = tmp[1]+dy[i];
				if(nx>0&&nx<=N&&ny>0&&ny<=M&&!visited[nx][ny]&&map[nx][ny]==0) {
					visited[nx][ny]=true;
					queue.add(new int[] {nx,ny});
				}else if(nx>0&&nx<=N&&ny>0&&ny<=M&&!visited[nx][ny]&&map[nx][ny]>0) {
					map[nx][ny]++;
					if(map[nx][ny]>=3) {
						visited[nx][ny]=true;
						destroy.add(new int[] {nx,ny});
					}
				}
			}
		}
		return destroy;
	}
}
