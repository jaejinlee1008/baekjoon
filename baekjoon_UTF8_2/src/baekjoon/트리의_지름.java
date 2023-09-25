package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 트리의_지름 {
	static class Edge{
		int to;
		int weight;
		public Edge(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}
		
	}
	static int N;
	static List<Edge>[] edgeList;
	static int node;
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		edgeList = new List[N+1];
		for(int i=1;i<=N;i++) {
			edgeList[i] = new ArrayList<>();
		}
		for(int i=1;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			edgeList[a].add(new Edge(b,w));
			edgeList[b].add(new Edge(a,w));
		}
		DFS(1,0,new boolean[N+1]);
		DFS(node,0,new boolean[N+1]);
		System.out.println(max);
	}
	private static void DFS(int start,int sum,boolean[] visited) {
		visited[start]=true;
		boolean flag = false;
		for(Edge e : edgeList[start]) {
			if(!visited[e.to]) {
				DFS(e.to,sum+e.weight,visited);
				flag = true;
			}
		}
		if(!flag) {
			if(max<sum) {
				max = sum;
				node = start;
				return;
			}
		}
	}
}
