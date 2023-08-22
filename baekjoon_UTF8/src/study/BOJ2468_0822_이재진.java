package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2468_0822_이재진 {
	static int N,len;
	static int[][] map;
	static boolean[][] visited;
	static int result = Integer.MIN_VALUE;
	static int max = Integer.MIN_VALUE;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		map = new int[N][N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				max = Math.max(map[i][j], max);
			}
		}
		for(int i=0;i<=max;i++) {
			len = i;
			visited = new boolean[N][N];
			for(int j=0;j<N;j++) {
				for(int k=0;k<N;k++) {
					if(map[j][k]<=len) {
						visited[j][k]=true;
					}
				}
			}
			int cnt=0;
			for(int j=0;j<N;j++) {
				for(int k=0;k<N;k++) {
					if(!visited[j][k]) {
						BFS(j,k);
						cnt++;
					}
				}
			}
			result = Math.max(result, cnt);
		}
		System.out.println(result);
	}
	private static void BFS(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x,y});
		visited[x][y]=true;
		while(!queue.isEmpty()) {
			int[] tmp = queue.poll();
			for(int i=0;i<4;i++) {
				int nx = tmp[0]+dx[i];
				int ny = tmp[1]+dy[i];
				if(nx>=0&&nx<N&&ny>=0&&ny<N&&!visited[nx][ny]&&map[nx][ny]>len) {
					visited[nx][ny]=true;
					queue.add(new int[] {nx,ny});
				}
			}
		}
	}
}
