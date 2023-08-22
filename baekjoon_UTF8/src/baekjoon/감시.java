package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 감시 {
	static int N,M,count;
	static int min = Integer.MAX_VALUE;
//	static int[][] map;
	static boolean[][] visited;
	static List<int[]> cctv = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		visited = new boolean[N][M];
		count=0;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==6) visited[i][j]=true;
				else if(map[i][j]>0) {
					cctv.add(new int[] {i,j});
					count++;
				}
			}
		}
		DFS(map,0);
		System.out.println(min);
	}
	
	private static void DFS(int[][] map,int cnt) {
		if(count==cnt) {
			int num=0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(map[i][j]==0) num++;
				}
			}
			min = Math.min(min, num);
			return;
		}
		int i = cctv.get(cnt)[0];
		int j = cctv.get(cnt)[1];
		if(map[i][j]==1) {
			DFS(right(map,i,j),cnt+1);
			DFS(left(map,i,j),cnt+1);
			DFS(up(map,i,j),cnt+1);
			DFS(down(map,i,j),cnt+1);
		}else if(map[i][j]==2) {
			DFS(right(left(map,i,j),i,j),cnt+1);
			DFS(up(down(map,i,j),i,j),cnt+1);
		}else if(map[i][j]==3) {
			DFS(up(right(map,i,j),i,j),cnt+1);
			DFS(right(down(map,i,j),i,j),cnt+1);
			DFS(down(left(map,i,j),i,j),cnt+1);
			DFS(left(up(map,i,j),i,j),cnt+1);
		}else if(map[i][j]==4) {
			DFS(left(up(right(map,i,j),i,j),i,j),cnt+1);
			DFS(up(right(down(map,i,j),i,j),i,j),cnt+1);
			DFS(right(down(left(map,i,j),i,j),i,j),cnt+1);
			DFS(down(left(up(map,i,j),i,j),i,j),cnt+1);
		}else if(map[i][j]==5) {
			DFS(down(left(up(right(map,i,j),i,j),i,j),i,j),cnt+1);
		}
	}
	private static int[][] right(int[][]map,int i,int j) {
		int[][] tmp = new int[N][M];
		for(int x=0;x<N;x++) {
			for(int y=0;y<M;y++) {
				tmp[x][y]=map[x][y];
			}
		}
		int nx = i;
		int ny = j+1;
		while(true) {
			
			if(ny==M||tmp[nx][ny]==6) break;
			if(tmp[nx][ny]>0) {
				ny++;
				continue;
			}else {
				tmp[nx][ny]=-1;
				ny++;
			}
		}
		return tmp;
	}
	private static int[][] left(int[][]map,int i,int j) {
		int[][] tmp = new int[N][M];
		for(int x=0;x<N;x++) {
			for(int y=0;y<M;y++) {
				tmp[x][y]=map[x][y];
			}
		}
		int nx = i;
		int ny = j-1;
		while(true) {
			
			if(ny<0||tmp[nx][ny]==6) break;
			if(tmp[nx][ny]>0) {
				ny--;
				continue;
			}else {
				tmp[nx][ny]=-1;
				ny--;
			}
		}
		return tmp;
	}
	private static int[][] up(int[][]map,int i,int j) {
		int[][] tmp = new int[N][M];
		for(int x=0;x<N;x++) {
			for(int y=0;y<M;y++) {
				tmp[x][y]=map[x][y];
			}
		}
		int nx = i-1;
		int ny = j;
		while(true) {
			
			if(nx<0||tmp[nx][ny]==6) break;
			if(tmp[nx][ny]>0) {
				nx--;
				continue;
			}else {
				tmp[nx][ny]=-1;
				nx--;
			}
		}
		return tmp;
	}
	private static int[][] down(int[][]map,int i,int j) {
		int[][] tmp = new int[N][M];
		for(int x=0;x<N;x++) {
			for(int y=0;y<M;y++) {
				tmp[x][y]=map[x][y];
			}
		}
		int nx = i+1;
		int ny = j;
		while(true) {
			
			if(nx==N||tmp[nx][ny]==6) break;
			if(tmp[nx][ny]>0) {
				nx++;
				continue;
			}else {
				tmp[nx][ny]=-1;
				nx++;
			}
		}
		return tmp;
	}
}
