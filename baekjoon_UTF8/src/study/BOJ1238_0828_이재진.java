package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1238_0828_이재진 {
	static class Edge{
		int to;
		int weight;
		
		public Edge(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}
		
	}
	static int N,M,X;
	static ArrayList<Edge>[] edgeList;
	static boolean[] visited;
	static int[] result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		edgeList = new ArrayList[N+1];
		result = new int[N+1];
		for(int i=1;i<=N;i++) {
			edgeList[i] = new ArrayList<>();
		}
		for(int i=1;i<=M;i++) {
			
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edgeList[from].add(new Edge(to,weight));
		}
		
		for(int i=1;i<=N;i++) {
			result[i]=Dijkstra(i, X)+Dijkstra(X, i);
		}
		int max=Integer.MIN_VALUE;
		for(int i=1;i<=N;i++) {
			max = Math.max(max, result[i]);
		}
		System.out.println(max);
	}
	private static int Dijkstra(int start, int end) {
		int[] dist = new int[N+1];
		visited = new boolean[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start]=0;
		int vertex=0;
		int minCost=0;
		for(int j=1;j<=N;j++) {
			vertex=-1;
			minCost = Integer.MAX_VALUE;
			for(int k=1;k<=N;k++) {
				if(!visited[k]&&minCost>dist[k]) {
					vertex=k;
					minCost = dist[k];
				}
			}
			if(vertex==-1) break;
			if(vertex==end) {
				break;
			}
			visited[vertex]=true;
			for(Edge e : edgeList[vertex]) {
				if(!visited[e.to]&&dist[e.to]>minCost+e.weight) {
					dist[e.to] = minCost+e.weight;
				}
			}
			
		}
		return dist[end];
	}
}
