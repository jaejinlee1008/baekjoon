package study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ5427_0825_이재진 {
	static int w,h;
	static char[][] map;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static boolean[][] visited;
	static List<int[]> list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			map = new char[w][h];
			visited = new boolean[w][h];
			list = new ArrayList<>();
			int[] start = new int[3];
			for(int j=0;j<w;j++) {
				String str = br.readLine();
				for(int k=0;k<h;k++) {
					map[j][k] = str.charAt(k);
					if(map[j][k]=='#') visited[j][k]=true;
					else if(map[j][k]=='*') list.add(new int[] {j,k});
					else if(map[j][k]=='@') {
						start[0]=j;
						start[1]=k;
					}
				}
			}
//			for(char[] c : map) {
//				System.out.println(Arrays.toString(c));
//			}
			list.add(start);
			String result = BFS();
			bw.write(result+"\n");
		}
		bw.flush();
	}
	private static String BFS() {
		Queue<int[]> queue = new LinkedList<>();
		for(int[] pos : list) {
			queue.add(pos);
		}
		int num=0;
		boolean flag=false;
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
//			System.out.println(Arrays.toString(cur));
//			System.out.println(map[cur[0]][cur[1]]);
			if((cur[0]==0||cur[0]==w-1||cur[1]==0||cur[1]==h-1)&&cur.length==3) {
				flag = true;
				num = cur[2];
				break;
			}
			if(cur.length==2) { //불이 먼저 번지고
				for(int i=0;i<4;i++) {
					int nx = cur[0]+dx[i];
					int ny = cur[1]+dy[i];
					if(nx>=0&&nx<w&&ny>=0&&ny<h&&map[nx][ny]!='#'&&map[nx][ny]!='*') {
						map[nx][ny]='*';
						queue.add(new int[] {nx,ny});
					}
				}
			}else if(cur.length==3){ //사람 이동
				for(int i=0;i<4;i++) {
					int nx = cur[0]+dx[i];
					int ny = cur[1]+dy[i];
					if(nx>=0&&nx<w&&ny>=0&&ny<h&&map[nx][ny]=='.'&&!visited[nx][ny]) {
						visited[nx][ny]=true;
						map[nx][ny]='@';
						queue.add(new int[] {nx,ny,cur[2]+1});
					}
				}
			}
			
		}
		if(flag) {
			return Integer.toString(num+1);
		}else {
			return "IMPOSSIBLE";
		}
	}
}
