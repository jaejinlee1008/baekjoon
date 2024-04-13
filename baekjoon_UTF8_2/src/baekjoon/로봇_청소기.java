package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 로봇_청소기 {
	static int N,M;
	static int curx,cury;
	static int curd;
	static int count;
	static int[][] room;
	static boolean[][] visited;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		curx = Integer.parseInt(st.nextToken());
		cury = Integer.parseInt(st.nextToken());
		curd = Integer.parseInt(st.nextToken());
		room = new int[N][M];
		visited = new boolean[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
				
			}
		}
		while(true) {
			if(!visited[curx][cury]) {
				clean();
			}
			boolean flag = false;
			for(int i=0;i<4;i++) {
				int nx = curx+dx[i];
				int ny = cury+dy[i];
				if(nx>=0&&nx<N&&ny>=0&&ny<M&&room[nx][ny]==0&&!visited[nx][ny]) {
					flag = true;
				}
			}
			if(flag) {
				yesRoom();
				
			}else {
				if(!noRoom()) {
					break;
				}
			}
//			for(int i=0;i<N;i++) {
//				System.out.println(Arrays.toString(visited[i]));
//			}
		}
		System.out.println(count);
	}
	private static void clean() {
		visited[curx][cury]=true;
		count++;
	}
	private static boolean noRoom() {
		int tmpd=0;
		if(curd==0) {
			tmpd=2;
		}else if(curd==1) {
			tmpd=3;
		}else if(curd==2) {
			tmpd=0;
		}else {
			tmpd=1;
		}
		int nx = curx+dx[tmpd];
		int ny = cury+dy[tmpd];
		if(nx>=0&&nx<N&&ny>=0&&ny<M&&room[nx][ny]==0) {
			curx = nx;
			cury = ny;
			return true;
		}else {
			return false;
		}
	}
	private static void yesRoom() {
		if(curd>=1) {
			curd--;
		}else {
			curd=3;
		}
		int nx = curx+dx[curd];
		int ny = cury+dy[curd];
		if(nx>=0&&nx<N&&ny>=0&&ny<M&&room[nx][ny]==0&&!visited[nx][ny]) {
			curx = nx;
			cury = ny;
		}
	}
}
