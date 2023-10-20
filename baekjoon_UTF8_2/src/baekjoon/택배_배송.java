package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 택배_배송 {
	static class Edge implements Comparable<Edge>{
		int to;
		int weight;
		public Edge(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	static int N,M;
	static List<Edge>[] list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new List[N+1];
		for(int i=1;i<=N;i++) {
			list[i] = new ArrayList<>();
		}
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[a].add(new Edge(b,w));
			list[b].add(new Edge(a,w));
		}
		int result = dijkstra();
		System.out.println(result);
	}
	private static int dijkstra() {
		boolean[] visited = new boolean[N+1];
		int[] dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[1]=0;
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(1,0));
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			if(visited[edge.to]) continue;
			visited[edge.to]=true;
			for(Edge e : list[edge.to]) {
				if(dist[e.to]>dist[edge.to]+e.weight) {
					dist[e.to] = dist[edge.to]+e.weight;
					pq.add(new Edge(e.to,dist[e.to]));
				}
			}
		}
		return dist[N];
	}
}
