package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 헌내기는_친구가_필요해 {
	static int N;
	static int M;
	static char[][] map;
	static int count=0;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int x=0;
		int y=0;
		map = new char[N][M];
		visited = new boolean[N][M];
		for(int i=0;i<N;i++) {
			String tmp = br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j] = tmp.charAt(j);
				if(map[i][j]=='I') {
					x=i;
					y=j;
				}else if(map[i][j]=='X') {
					visited[i][j]=true;
				}
			}
		}
		BFS(x,y);
		if(count>0) {
			System.out.println(count);
		}else {
			System.out.println("TT");
		}
		
	}
	private static void BFS(int x,int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x,y});
		visited[x][y]=true;
		while(!queue.isEmpty()) {
			int[] tmp = queue.poll();
			for(int i=0;i<4;i++) {
				int nx = tmp[0]+dx[i];
				int ny = tmp[1]+dy[i];
				if(nx>=0&&nx<N&&ny>=0&&ny<M&&!visited[nx][ny]&&map[nx][ny]!='X') {
					if(map[nx][ny]=='P') {
						count++;
					}
					visited[nx][ny]=true;
					queue.add(new int[] {nx,ny});
				}
			}
		}
	}
}
