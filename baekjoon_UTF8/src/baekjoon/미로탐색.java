package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로탐색 {
	static int N;
	static int M;
	static int[][] miro;
	static boolean[][] visited;
	static int[] dx= {-1,1,0,0};
	static int[] dy= {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		miro = new int[N][M];
		visited = new boolean[N][M];
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<M;j++) {
				miro[i][j] = (str.charAt(j)-'0');
				if(miro[i][j]==0) {
					visited[i][j]=true;
				}
			}
		}
		BFS(0,0);
		System.out.println(miro[N-1][M-1]);
		
	}
	private static void BFS(int x,int y) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {x,y});
		visited[x][y]=true;
		while(!queue.isEmpty()) {
			int[] tmp = queue.poll();
			if(tmp[0]==N-1&&tmp[1]==M-1) return;
			for(int i=0;i<4;i++) {
				int nx = tmp[0]+dx[i];
				int ny = tmp[1]+dy[i];
				
				if(nx>=0&&nx<N&&ny>=0&&ny<M&&!visited[nx][ny]&&miro[nx][ny]==1) {
					miro[nx][ny] = miro[tmp[0]][tmp[1]]+1;
					visited[nx][ny]=true;
					queue.add(new int[] {nx,ny});
				}
			}
		}
	}
}
