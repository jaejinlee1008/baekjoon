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
	static int[] dist;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		edgeList = new ArrayList[N+1];
		
		for(int i=1;i<=M;i++) {
			edgeList[i] = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edgeList[from].add(new Edge(to,weight));
		}
		for(int i=1;i<=M;i++) {
			dist = new int[N+1];
			visited = new boolean[N+1];
			Arrays.fill(dist, Integer.MAX_VALUE);
			dist[i]=0;
			
			int vertex=0;
			int minCost=0;
			for(int j=1;j<=M;j++) {
				vertex=-1;
				minCost = Integer.MAX_VALUE;
				for(int k=1;k<=M;k++) {
					if(!visited[k]&&minCost>dist[k]) {
						vertex=k;
						minCost = dist[k];
					}
				}
			}
		}
		
		
	}
	private static void Dijkstra() {
		
	}
}
