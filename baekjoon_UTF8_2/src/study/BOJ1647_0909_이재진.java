package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1647_0909_이재진 {
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
	static ArrayList<Edge>[] edgeList;
	static boolean[] visited;
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		edgeList = new ArrayList[N+1];
		visited = new boolean[N+1];
		for(int i=1;i<=N;i++) {
			edgeList[i] = new ArrayList<>();
		}
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			edgeList[a].add(new Edge(b,w));
			edgeList[b].add(new Edge(a,w));
		}
		int result = prim(1,0);
		System.out.println(result-max);
	}
	
	private static int prim(int start,int sum) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(start,0));
		while(!pq.isEmpty()) {
			Edge e = pq.poll();
			int to = e.to;
			int cost = e.weight;
			if(visited[to]) continue;
			visited[to] = true;
			sum+=cost;
			max = Math.max(max, cost);
			for(Edge edge : edgeList[to]) {
				if(!visited[edge.to]) {
					pq.add(edge);
				}
			}
		}
		return sum;
	}
}
