package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 웜홀 {
	static class Edge{
		int to;
		int weight;
		
		public Edge(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Edge [to=" + to + ", weight=" + weight + "]";
		}
		
	}
	static ArrayList<Edge>[] edgeList;
	static List<Integer> startList;
	static String result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int TC = Integer.parseInt(br.readLine());
		for(int t=1;t<=TC;t++) {
			result="NO";
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			edgeList = new ArrayList[N+1];
			startList = new ArrayList<>();
			for(int i=1;i<=N;i++) {
				edgeList[i] = new ArrayList<>();
			}
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int S = Integer.parseInt(st.nextToken());
				int E = Integer.parseInt(st.nextToken());
				int T = Integer.parseInt(st.nextToken());
				edgeList[S].add(new Edge(E,T));
				edgeList[E].add(new Edge(S,T));
			}
			for(int i=0;i<W;i++) {
				st = new StringTokenizer(br.readLine());
				int S = Integer.parseInt(st.nextToken());
				int E = Integer.parseInt(st.nextToken());
				int T = Integer.parseInt(st.nextToken());
				edgeList[S].add(new Edge(E,-T));
				startList.add(S);
			}
			for(int vertex : startList) {
				for(Edge e : edgeList[vertex]) {
					dfs(e.to,vertex,e.weight,new boolean[N+1]);
				}
				
			}
			bw.write(result+"\n");
		}
		bw.flush();
	}
	private static void dfs(int vertex,int end,int sum,boolean[] visited) {
		
		visited[vertex]=true;
		for(Edge e : edgeList[vertex]) {
			if(e.to==end) {
				if(sum+e.weight<0) {
					result="Yes";
				}
			}
			if(!visited[e.to]) {
				dfs(e.to,end,sum+e.weight,visited);
			}
				
		}
		return;
	}
}
