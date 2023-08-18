package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 캐슬_디펜스 {
	static int N,M,D;
	static int[][] arr;
	static int[] output;
	static int[] dx = {-1,0,0};
	static int[] dy = {0,-1,1};
	static int max = Integer.MIN_VALUE;
	static int enemy;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		arr = new int[N+1][M];
		output = new int[3];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==1) enemy++;
			}
		}
		comb(0,0);
		System.out.println(max);
	}
	private static void comb(int cnt,int start) {
		if(cnt==3) {
			int[][] tmp = new int[N+1][M];
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					tmp[i][j] = arr[i][j];
				}
			}
			max = Math.max(BFS(output,tmp),max);
			System.out.println("-----------------------------------");
			return;
		}
		for(int i=start;i<M;i++) {
			output[cnt]=i;
			comb(cnt+1,i+1);
		}
	}
	private static int BFS(int[] p,int[][] map) {
		int num=0;
		Queue<int[]> queue = new LinkedList<>();
		for(int row=N;row>=0;row--) {
			for(int i=0;i<3;i++) {
				System.out.println(p[i]+"번째 궁수");
				boolean[][] visited = new boolean[row+1][M];
				queue.add(new int[] {row,p[i],0});
				visited[row][p[i]]=true;
				while(!queue.isEmpty()) {
					int[] tmp = queue.poll();
					System.out.println(Arrays.toString(tmp));
					if(map[tmp[0]][tmp[1]]==1) {
						num++;
						if(num==enemy) return num;
						map[tmp[0]][tmp[1]]=0;
						System.out.println("병사죽음, "+num);
						queue.clear();
						break;
					}
					
					for(int j=0;j<3;j++) {
						int nx = tmp[0]+dx[j];
						int ny = tmp[1]+dy[j];
//						System.out.println(nx+","+ny);
						if(nx>=0&&nx<row&&ny>=0&&ny<M&&!visited[nx][ny]&&tmp[2]<D) {
							visited[nx][ny]=true;
							queue.add(new int[] {nx,ny,tmp[2]+1});
//							System.out.println("add : "+nx+","+ny+","+(tmp[2]+1));
						}
					}
				}
			}
			
			System.out.println("한 칸 위로");
		}
		
		return num;
	}
}
