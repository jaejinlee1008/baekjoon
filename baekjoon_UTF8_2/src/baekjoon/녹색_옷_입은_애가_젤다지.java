package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 녹색_옷_입은_애가_젤다지 {
	
	
	static class Node implements Comparable<Node>{
		int x;
		int y;
		int weight;
		
		public Node(int x, int y, int weight) {
			super();
			this.x = x;
			this.y = y;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.weight, o.weight);
		}
		
		
	}
	
	static int N;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static int min = Integer.MAX_VALUE;
	static int[][] dist;
	static int[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int idx=1;
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N==0) break;
			min = Integer.MAX_VALUE;
			map = new int[N][N];
			for(int i=0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
				
			}
			
			dist = new int[N][N];
			for(int i=0;i<N;i++) {
				Arrays.fill(dist[i], Integer.MAX_VALUE);
			}
			dijkstra();
			System.out.println("Problem "+idx+": "+min);
			idx++;
		}
	}
	private static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(0,0,map[0][0]));
		dist[0][0]=map[0][0];
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			for(int i=0;i<4;i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				if(nx>=0&&nx<N&&ny>=0&&ny<N) {
					if(dist[nx][ny]>dist[node.x][node.y]+map[nx][ny]) {
						dist[nx][ny] = dist[node.x][node.y]+map[nx][ny];
						pq.add(new Node(nx,ny,dist[nx][ny]));
					}
				}
			}
		}
//		for(int i=0;i<N;i++) {
//			System.out.println(Arrays.toString(dist[i]));
//		}
		min = dist[N-1][N-1];
	}
}
