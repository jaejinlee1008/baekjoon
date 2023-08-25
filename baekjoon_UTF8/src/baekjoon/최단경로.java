package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 최단경로 {
	static class Edge{
		int to,weight;

		public Edge(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}
				
	}
	static List<Edge>[] edgeList;
	static int V,E,W;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(br.readLine());
		edgeList = new ArrayList[V+1];
		for(int i=1;i<=V;i++) {
			edgeList[i] = new ArrayList<>();
		}
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edgeList[from].add(new Edge(to,weight));
		}
		int[] dist = new int[V+1];
		boolean[] visited = new boolean[V+1];
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[W] = 0;
		int vertex=0;
		int minCost=0;
		for(int i=0;i<V;i++) {
			vertex=-1;
			minCost = Integer.MAX_VALUE;
			
			for(int j=1;j<=V;j++) {
				if(!visited[j]&&dist[j]<minCost) {
					vertex=j;
					minCost = dist[j];
				}
			}
			if(vertex==-1) break;
			visited[vertex]=true;
			
			for(Edge e : edgeList[vertex]) {
				if(!visited[e.to]&&dist[e.to]>minCost+e.weight) {
					dist[e.to] = minCost+e.weight;
				}
			}
		}
		for(int i=1;i<=V;i++) {
			if(dist[i]<Integer.MAX_VALUE) {
				System.out.println(dist[i]);
			}else {
				System.out.println("INF");
			}
		}
	}
}
