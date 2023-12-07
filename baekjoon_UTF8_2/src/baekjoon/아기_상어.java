package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 아기_상어 {
	static int N;
	static int[][] map;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static int[] cur = new int[2];
	static int size=2;
	static int eat=0;
	static List<int[]> canEat = null;
	static int cnt=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==9) {
					cur[0]=i;
					cur[1]=j;
				}
			}
		}
		while(true) {
			bfs();
			if(canEat==null||canEat.size()==0) {
//				System.out.println("탐색종료");
				break;
			}
			Collections.sort(canEat,new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					if(o1[2]==o2[2]) {
						if(o1[0]==o2[0]) {
							return o1[1]-o2[1];
						}else {
							return o1[0]-o2[0];
						}
					}else {
						return o1[2]-o2[2];
					}
				}
				
			});
//			for(int[] arr : canEat) {
//				System.out.println(Arrays.toString(arr));
//			}
//			System.out.println("------------------------");
			eat++;
			cnt+=canEat.get(0)[2];
			map[cur[0]][cur[1]]=0;
			cur[0] = canEat.get(0)[0];
			cur[1] = canEat.get(0)[1];
			map[cur[0]][cur[1]]=9;
			if(eat==size) {
				size++;
				eat=0;
			}
//			for(int[] arr : map) {
//				System.out.println(Arrays.toString(arr));
//			}
//			System.out.println("------------------------");
		}
		
		System.out.println(cnt);
		
	}
	private static void bfs() {
		boolean[][] visited = new boolean[N][N];
		canEat = new ArrayList<>();
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {cur[0],cur[1],0});
		visited[cur[0]][cur[1]] = true;
		while(!queue.isEmpty()) {
			int[] tmp = queue.poll();
			if(map[tmp[0]][tmp[1]]>=1&&map[tmp[0]][tmp[1]]<size&&map[tmp[0]][tmp[1]]!=9) {
				canEat.add(tmp);
			}
			for(int i=0;i<4;i++) {
				int nx = tmp[0] + dx[i];
				int ny = tmp[1] + dy[i];
				if(nx>=0&&nx<N&&ny>=0&&ny<N&&!visited[nx][ny]&&map[nx][ny]<=size) {
					visited[nx][ny]=true;
					queue.add(new int[] {nx,ny,tmp[2]+1});
				}
			}
		}
	}
}
