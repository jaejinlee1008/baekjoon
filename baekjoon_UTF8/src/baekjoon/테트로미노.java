package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 테트로미노 {
	static int N;
	static int M;
	static int[][] map;
	static int max=Integer.MIN_VALUE;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				BFS(i,j);
				try {
					max = Math.max(map[i][j]+map[i-1][j-1]+map[i-1][j]+map[i-1][j+1], max);
				} catch (Exception e) {
				}
				try {
					max = Math.max(map[i][j]+map[i-1][j-1]+map[i][j-1]+map[i+1][j-1], max);
				} catch (Exception e) {
				}
				try {
					max = Math.max(map[i][j]+map[i+1][j-1]+map[i+1][j]+map[i+1][j+1], max);
				} catch (Exception e) {
				}
				try {
					max = Math.max(map[i][j]+map[i-1][j+1]+map[i][j+1]+map[i+1][j+1], max);
				} catch (Exception e) {
				}
			}
		}
		System.out.println(max);
	}
	private static void BFS(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x,y,map[x][y],1});
		while(!queue.isEmpty()) {
			int[] tmp = queue.poll();
			if(tmp[3]==4) {
				max=Math.max(max, tmp[2]);
			}else if(tmp[3]<4) {
				for(int i=0;i<4;i++) {
					int nx = tmp[0]+dx[i];
					int ny = tmp[1]+dy[i];
					if(nx>=0&&nx<N&&ny>=0&&ny<M&&tmp[3]==1) {
						queue.add(new int[] {nx,ny,map[nx][ny]+tmp[2],tmp[3]+1,tmp[0],tmp[1]});
//						System.out.println(nx+","+ny+"next : " + map[nx][ny]+"cur : "+tmp[0]+","+tmp[1]+","+tmp[2]);
					}else if(nx>=0&&nx<N&&ny>=0&&ny<M&&tmp[3]>=1&&(nx!=tmp[4]||ny!=tmp[5])) {
						queue.add(new int[] {nx,ny,map[nx][ny]+tmp[2],tmp[3]+1,tmp[0],tmp[1]});
//						System.out.println(nx+","+ny+"next : " + map[nx][ny]+"cur : "+tmp[0]+","+tmp[1]+","+tmp[2]);
					}
				}
			}
			
		}
	}
}
