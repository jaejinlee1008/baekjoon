package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1504_0921_이재진 {
	
	static class Edge{
		int to;
		int weight;
		
		public Edge(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
		
	}
	static ArrayList<Edge>[] edgeList;
	static int N,E,result;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		edgeList = new ArrayList[N+1];
		for(int i=1;i<=N;i++) {
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
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		arr = new int[2][2];
		arr[0][0] = v1;
		arr[0][1] = v2;
		arr[1][0] = v2;
		arr[1][1] = v1;
		long sum=Long.MAX_VALUE;
		for(int i=0;i<2;i++) {
			long len1 = Dijkstra(1, arr[i][0]);
			long len2 = Dijkstra(arr[i][0], arr[i][1]);
			long len3 = Dijkstra(arr[i][1], N);
			if(len1!=-1&&len2!=-1&&len3!=-1) {
				sum = Math.min(sum, len1+len2+len3);
			}
		}
		if(sum==Long.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(sum);
		}
	}
	private static long Dijkstra(int start, int end) {
		long[] dist = new long[N+1];
		boolean[] visited = new boolean[N+1];
		Arrays.fill(dist, Long.MAX_VALUE);
		dist[start]=0;
		int vertex=0;
		long minCost=0;
		for(int i=1;i<=N;i++) {
			vertex=-1;
			minCost = Integer.MAX_VALUE;
			for(int j=1;j<=N;j++) {
				if(!visited[j]&&minCost>dist[j]) {
					vertex=j;
					minCost = dist[j];
				}
			}
			if(vertex==-1) break;
			if(vertex==end) {
				break;
			}
			visited[vertex]=true;
			for(Edge e : edgeList[vertex]) {
				if(!visited[e.to]&&dist[e.to]>minCost+e.weight) {
					dist[e.to]=minCost+e.weight;
				}
			}
		}
		if(dist[end]==Long.MAX_VALUE) {
			return -1;
		}
		return dist[end];
	}
	// 다익스트라 연습
//	private static int test(int start,int end) {
//		int[] dist = new int[N+1];
//		boolean[] visited = new boolean[N+1];
//		Arrays.fill(dist, Integer.MAX_VALUE);
//		int vertex=0;
//		int minCost=0;
//		for(int i=1;i<=N;i++) {
//			vertex=-1;
//			minCost = Integer.MAX_VALUE;
//			for(int j=1;j<=N;j++) {
//				if(!visited[j]&&minCost>dist[j]) {
//					minCost = dist[j];
//					vertex=j;
//				}
//			}
//			if(vertex==-1||vertex==end) break;
//			visited[vertex]=true;
//			for(Edge e : edgeList[vertex]) {
//				if(!visited[e.to]&&dist[e.to]>minCost+e.weight) {
//					dist[e.to] = minCost+e.weight;
//				}
//			}
//		}
//		return dist[end];
//	}
}
