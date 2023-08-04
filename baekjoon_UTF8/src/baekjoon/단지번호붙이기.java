package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class 단지번호붙이기 {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static PriorityQueue<Integer> pq = new PriorityQueue<>();
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		for(int i=0;i<N;i++) {
			char[] input = br.readLine().toCharArray();
			for(int j=0;j<N;j++) {
				map[i][j] = input[j]-'0';
				if(map[i][j]==0) visited[i][j]=true;
			}
		}
		int count=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!visited[i][j]&&map[i][j]==1) {
					pq.add(BFS(i,j));
					count++;
				}
			}
		}
		bw.write(Integer.toString(count)+"\n");
		for(int i=0;i<count;i++) {
			bw.write(Integer.toString(pq.poll())+"\n");
		}
		bw.flush();
		
	}
	
	private static int BFS(int x,int y) {
		int count=1;
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x,y});
		visited[x][y]=true;
		while(!queue.isEmpty()) {
			int[] tmp = queue.poll();
			for(int i=0;i<4;i++) {
				int nx = tmp[0]+dx[i];
				int ny = tmp[1]+dy[i];
				
				if(nx>=0&&nx<N&&ny>=0&&ny<N&&!visited[nx][ny]&&map[nx][ny]==1) {
					map[nx][ny] = map[tmp[0]][tmp[1]]+1;
					visited[nx][ny]=true;
					queue.add(new int[] {nx,ny});
					count++;
				}
			}
		}
		return count;
	}
}
