package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 벽_부수고_이동하기 {
	static int N,M;
	static char[][] map;
	static boolean[][][] visited2;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int result1;
	static List<Integer> result2;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N+1][M+1];
		visited2 = new boolean[N+1][M+1][2];
		for(int i=1;i<=N;i++) {
			char[] input = br.readLine().toCharArray();
			for(int j=1;j<=M;j++) {
				map[i][j] = input[j-1];
				if(map[i][j]=='1') {
					visited2[i][j][0]=true;
				}
			}
		}
		bfs2();
		int min=Integer.MAX_VALUE;
		for(int i : result2) {
			if(i>0&&i<min) {
				min = i;
			}
		}
		if(min==Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(min);
		}

	}
	
	public static void bfs2() {
		Queue<int[]> queue = new LinkedList<>();
		result2 = new ArrayList<>();
		queue.add(new int[] {1,1,1,0});
		visited2[1][1][0] = true;
		while(!queue.isEmpty()) {
			int[] tmp = queue.poll();
			if(tmp[0]==N&&tmp[1]==M) {
				result2.add(tmp[2]);
			}
			for(int i=0;i<4;i++) {
				int nx = tmp[0]+dx[i];
				int ny = tmp[1]+dy[i];
				if(nx<1||nx>N||ny<1||ny>M) continue;
				if(tmp[3]==1) {
					if(map[nx][ny]=='0'&&!visited2[nx][ny][1]) {
						visited2[nx][ny][1]=true;
						queue.add(new int[] {nx,ny,tmp[2]+1,1});
					}
				}else if(tmp[3]==0){
					if(!visited2[nx][ny][0]&&map[nx][ny]=='0') {
						visited2[nx][ny][0]=true;
						queue.add(new int[] {nx,ny,tmp[2]+1,0});
					}else if(map[nx][ny]=='1'){
						visited2[nx][ny][1]=true;
						queue.add(new int[] {nx,ny,tmp[2]+1,1});
					}
				}
			}
		}
	}
}
