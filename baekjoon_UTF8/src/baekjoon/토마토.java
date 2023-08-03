package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토 {
	static int M;
	static int N;
	static int blankcount=0;
	static int[][] arr;
	static boolean[][] visited;
	static int max=Integer.MIN_VALUE;
	static List<int[]> list;
	static int[] dx= {0,0,1,-1};
	static int[] dy= {-1,1,0,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited = new boolean[N][M];
		list = new ArrayList<>();
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
				if(arr[i][j]==1) {
					list.add(new int[] {i,j});
					visited[i][j]=true;
				}else if(arr[i][j]==-1) {
					blankcount++;
					visited[i][j]=true;
				}
			}
		}
		if(list.size()==((N*M)-blankcount)) {
			System.out.println("0");
			return;
		}
		
		Queue<List<int[]>> queue = new LinkedList<>();
		queue.add(list);
		while(!queue.isEmpty()) {
			List<int[]> nlist = new ArrayList<>();
			for(int[] tmp : queue.poll()) {
				for(int i=0;i<4;i++) {
					int nx = tmp[0]+dx[i];
					int ny = tmp[1]+dy[i];
					
					if(nx>=0&&nx<N&&ny>=0&&ny<M&&!visited[nx][ny]&&arr[nx][ny]==0) {
						nlist.add(new int[] {nx,ny});
						arr[nx][ny]=arr[tmp[0]][tmp[1]]+1;
						max = Math.max(max, arr[nx][ny]);
					}
				}
			}
			if(nlist.size()>0) {
				queue.add(nlist);
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(!visited[i][j]&&arr[i][j]==0) {
					System.out.println("-1");
					return;
				}
			}
		}
		System.out.println(max-1);
	}
}
