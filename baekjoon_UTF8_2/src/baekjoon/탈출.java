package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 탈출 {
	static int R,C;
	static char[][] map;
	static boolean[][] visited;
	static List<int[]> waters = new ArrayList<>();
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int[] start = new int[2];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[R][C];
		for(int i=0;i<R;i++) {
			String str = br.readLine();
			for(int j=0;j<C;j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j]=='X') visited[i][j]=true;
				else if(map[i][j]=='S') {
					start[0]=i;
					start[1]=j;
				}else if(map[i][j]=='*') {
					waters.add(new int[] {i,j});
				}
			}
		}
		int result = bfs();
		if(result==0) {
			System.out.println("KAKTUS");
		}else {
			System.out.println(result);
		}
	}
	private static int bfs() {
		int cnt=0;
		Queue<int[]> queue = new LinkedList<>();
		for(int[] arr : waters) {
			queue.add(new int[] {arr[0],arr[1],-1});
		}
		queue.add(new int[] {start[0],start[1],0});
		visited[start[0]][start[1]]=true;
		while(!queue.isEmpty()) {
			int[] tmp = queue.poll();
			if(map[tmp[0]][tmp[1]]=='D') {
				cnt = tmp[2];
				break;
			}
			for(int i=0;i<4;i++) {
				int nx = tmp[0]+dx[i];
				int ny = tmp[1]+dy[i];
				if(nx>=0&&nx<R&&ny>=0&&ny<C&&!visited[nx][ny]) {
					
					if(tmp[2]==-1) {
						if(map[nx][ny]!='D') {
							visited[nx][ny]=true;
							queue.add(new int[] {nx,ny,tmp[2]});
						}
					}else {
						visited[nx][ny]=true;
						queue.add(new int[] {nx,ny,tmp[2]+1});
					}
				}
			}
		}
		return cnt;
	}
}
