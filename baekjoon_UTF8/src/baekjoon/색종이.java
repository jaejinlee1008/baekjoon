package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 색종이 {
	static int N = 100;
	static int[][] map = new int[N][N];
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int cnt=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());

			for (int j = y; j < y + 10; j++) {
				for (int k = x; k < x + 10; k++) {
					if (map[j][k]==0) {
						map[j][k] = 1;
					}
				}
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]==1) {
//					BFS(i,j);
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}

//	private static void BFS(int x, int y) {
//		Queue<int[]> queue = new LinkedList<>();
//		queue.add(new int[] { x, y });
//		map[x][y]=0;
//		cnt++;
//		while (!queue.isEmpty()) {
//			int[] tmp = queue.poll();
//			for (int i = 0; i < 4; i++) {
//				int nx = tmp[0]+dx[i];
//				int ny = tmp[1]+dy[i];
//				if(nx>=0&&nx<100&&ny>=0&&ny<N&&map[nx][ny]==1) {
//					map[nx][ny]=0;
//					queue.add(new int[] {nx,ny});
//					cnt++;
//				}
//			}
//		}
//	}
}
