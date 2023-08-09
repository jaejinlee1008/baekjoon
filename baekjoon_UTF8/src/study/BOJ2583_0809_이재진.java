package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2583_0809_이재진 {
	static int M;
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static List<Integer> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		visited = new boolean[M][N];
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			int starty = Integer.parseInt(st.nextToken());
			int startx = Integer.parseInt(st.nextToken());
			int endy = Integer.parseInt(st.nextToken());
			int endx = Integer.parseInt(st.nextToken());
			for(int j=startx;j<endx;j++) {
				for(int k=starty;k<endy;k++) {
					if(!visited[j][k]&&map[j][k]==0) {
						visited[j][k]=true;
						map[j][k]=1;
					}
				}
			}
//			for(int[] ar : map) {
//				System.out.println(Arrays.toString(ar));
//			}
//			System.out.println();
			
			
		}
		for(int j=0;j<M;j++) {
			for(int k=0;k<N;k++) {
				if(!visited[j][k]&&map[j][k]==0) {
					BFS(j,k);
				}
			}
		}
		Collections.sort(list);
		System.out.println(list.size());
		System.out.println(list.toString().substring(1,list.toString().length()-1).replace(",", ""));
	}
	private static void BFS(int x, int y) {
		
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x,y});
		visited[x][y]=true;
		int cnt=1;
		while(!queue.isEmpty()) {
			int[] tmp = queue.poll();
			for(int i=0;i<4;i++) {
				int nx = tmp[0]+dx[i];
				int ny = tmp[1]+dy[i];
				if(nx>=0&&nx<M&&ny>=0&&ny<N&&!visited[nx][ny]&&map[nx][ny]==0) {
					visited[nx][ny]=true;
					map[nx][ny]=1;
					queue.add(new int[] {nx,ny});
					cnt++;
				}
			}
		}
		list.add(cnt);
	}
}
