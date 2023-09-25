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

public class 연구소 {
	static int N,M;
	static int[][] map;
	static List<int[]> empty;
	static List<int[]> virus;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		empty = new ArrayList<>();
		virus = new ArrayList<>();
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==0) empty.add(new int[] {i,j});
				else if(map[i][j]==2) virus.add(new int[] {i,j});
			}
		}
		comb(0,0,new int[3]);
		System.out.println(max);
	}
	private static void comb(int cnt,int start,int[] output) {
		if(cnt==3) {
			int[][] newmap = new int[N][M];
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					newmap[i][j] = map[i][j];
				}
			}
			for(int i : output) {
				newmap[empty.get(i)[0]][empty.get(i)[1]] = 1;
			}
			int result = bfs(newmap);
			max = Math.max(result, max);
			return;
		}
		for(int i=start;i<empty.size();i++) {
			output[cnt]=i;
			comb(cnt+1,i+1,output);
		}
	}
	private static int bfs(int[][] newmap) {
		Queue<int[]> queue = new LinkedList<>();
		for(int[] arr : virus) {
			queue.add(arr);
		}
		while(!queue.isEmpty()) {
			int[] tmp = queue.poll();
			for(int i=0;i<4;i++) {
				int nx = tmp[0]+dx[i];
				int ny = tmp[1]+dy[i];
				if(nx>=0&&nx<N&&ny>=0&&ny<M&&newmap[nx][ny]==0) {
					newmap[nx][ny]=1;
					queue.add(new int[] {nx,ny});
				}
			}
		}
		int cnt=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(newmap[i][j]==0) cnt++;
			}
		}
		return cnt;
		
	}
}
