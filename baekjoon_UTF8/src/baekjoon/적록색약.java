package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 적록색약 {
	static int N;
	static char[][] map;
	static boolean[][] visited1;
	static boolean[][] visited2;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		visited1 = new boolean[N][N];
		visited2 = new boolean[N][N];
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			map[i]=str.toCharArray();
		}
		int count1=0;
		int count2=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!visited1[i][j]) {
					BFS1(i,j);
					count1++;
				}
				if(!visited2[i][j]) {
					BFS2(i,j);
					count2++;
				}
			}
		}
		System.out.println(count1+" "+count2);
	}
	private static void BFS1(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x,y});
		visited1[x][y]=true;
		while(!queue.isEmpty()) {
			int[] tmp = queue.poll();
			for(int i=0;i<4;i++) {
				int nx=tmp[0]+dx[i];
				int ny=tmp[1]+dy[i];
				if(nx>=0&&nx<N&&ny>=0&&ny<N&&!visited1[nx][ny]&&map[nx][ny]==map[tmp[0]][tmp[1]]) {
					visited1[nx][ny]=true;
					queue.add(new int[] {nx,ny});
				}
			}
		}
	}
	private static void BFS2(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x,y});
		visited2[x][y]=true;
		while(!queue.isEmpty()) {
			int[] tmp = queue.poll();
			for(int i=0;i<4;i++) {
				int nx=tmp[0]+dx[i];
				int ny=tmp[1]+dy[i];
				if(nx>=0&&nx<N&&ny>=0&&ny<N&&!visited2[nx][ny]) {
					if(map[tmp[0]][tmp[1]]=='B'&&map[nx][ny]==map[tmp[0]][tmp[1]]) {
						visited2[nx][ny]=true;
						queue.add(new int[] {nx,ny});
					}else if(map[tmp[0]][tmp[1]]!='B'&&map[nx][ny]!='B') {
						visited2[nx][ny]=true;
						queue.add(new int[] {nx,ny});
					}
					
				}
			}
		}
	}
}
