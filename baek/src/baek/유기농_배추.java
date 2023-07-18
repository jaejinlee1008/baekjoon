package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ¿Ø±‚≥Û_πË√ﬂ {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int col = Integer.parseInt(st.nextToken());
			int row = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			boolean[][] visited = new boolean[row][col];
			int[][] arr = new int[row][col];
			for(int n=0; n<K; n++) {
				st = new StringTokenizer(br.readLine());
				int y=Integer.parseInt(st.nextToken());
				int x =Integer.parseInt(st.nextToken());
				arr[x][y]=1;
			}
			System.out.println(BFS(visited,arr));
		}
		
	}
	public static int BFS(boolean[][] visited,int[][] arr) {
		int count=0;
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				if(arr[i][j]==1&&!visited[i][j]) {
					count++;
					Queue<int[]> q = new LinkedList<>();
					q.add(new int[] {i,j});
					while(!q.isEmpty()) {
						int[] tmp = q.poll();
						for(int k=0;k<4;k++) {
							int nx = tmp[0]+dx[k];
							int ny = tmp[1]+dy[k];
							if(nx>=0&&nx<arr.length&&ny>=0&&ny<arr[i].length&&arr[nx][ny]==1&&!visited[nx][ny]) {
								q.add(new int[] {nx,ny});
								arr[nx][ny]=0;
								visited[nx][ny]=true;
							}
						}
					}
					
				}
			}
		}
		return count;
	}
}
