package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;



public class 쉬운_최단거리 {
	static int[] dx = {-1,1,0,0}; //상하좌우
	static int[] dy = {0,0,-1,1};
	static int n;
	static int m;
	static int[] goal = new int[2];
	static boolean[][] visited;
	static int[][] arr;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		map = new int[n][m];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==2) {
					goal[0]=i;
					goal[1]=j;
				}
			}
		}
		visited = new boolean[n][m];
		BFS(goal[0],goal[1]);
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(arr[i][j]==1&&!visited[i][j]) {
					bw.write("-1 ");
				}else {
					bw.write(Integer.toString(map[i][j])+" ");
				}
			}
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();
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
				
				if(nx>=0&&nx<n&&ny>=0&&ny<m&&arr[nx][ny]==1&&!visited[nx][ny]) {
					visited[nx][ny]=true;
					map[nx][ny] = map[tmp[0]][tmp[1]]+1;
					queue.add(new int[] {nx,ny});
				}
			}
		}
	}
}
