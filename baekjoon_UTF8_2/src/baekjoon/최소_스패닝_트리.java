package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최소_스패닝_트리 {
	static class Edge implements Comparable<Edge>{
		int to;
		long weight;
		
		public Edge(int to, long weight) {
			super();
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.weight, o.weight);
		}
		
	}
	static int V,E;
	static List<Edge>[] edgeList;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		edgeList = new List[V+1];
		for(int i=1;i<=V;i++) {
			edgeList[i] = new ArrayList<>();
		}
		for(int i=1;i<=E;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			edgeList[a].add(new Edge(b,w));
			edgeList[b].add(new Edge(a,w));
		}
		long result = prim();
		System.out.println(result);
	}
	private static long prim() {
		boolean[] visited = new boolean[V+1];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(1,0));
		long total=0;
		while(!pq.isEmpty()) {
			Edge e = pq.poll();
			if(visited[e.to]) continue;
			
			visited[e.to]=true;
			total+=e.weight;
			for(Edge tmp : edgeList[e.to]) {
				if(!visited[tmp.to]) {
					pq.add(tmp);
				}
			}
		}
		return total;
	}
}
