package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 우주신과의_교감 {
	static class Pos{
		int x;
		int y;
		
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
	static class Edge implements Comparable<Edge>{
		int from;
		int to;
		double weight;
		public Edge(int from, int to, double weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.weight, o.weight);
		}
		
	}
	static int N,M;
	static Pos[] posList;
	static List<Edge> edgeList;
	static int[] parents;
	static void make() {
		parents = new int[N+1];
		for(int i=1;i<=N;i++) {
			parents[i]=i;
		}
	}
	
	static int find(int a) {
		if(parents[a]==a) return a;
		return parents[a] = find(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int aroot = find(a);
		int broot = find(b);
		if(aroot==broot) return false;
		parents[broot] = aroot;
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		posList = new Pos[N+1];
		edgeList = new ArrayList<>();
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			posList[i] = new Pos(x,y);
		}
		
		for(int i=1;i<=N;i++) {
			for(int j=i+1;j<=N;j++) {
				edgeList.add(new Edge(i,j,dist(i,j)));
			}
		}
		Collections.sort(edgeList);
		make();
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a,b);
		}
		
		double result=0;
//		int count=M;
		for(Edge edge : edgeList) {
			if(union(edge.from,edge.to)) {
				result+=edge.weight;
//				if(++count==N-1) break;
			}
		}
		System.out.println(String.format("%.2f", result));
	}
	private static double dist(int a, int b) {
		return Math.sqrt(Math.pow(posList[a].x-posList[b].x,2)+Math.pow(posList[a].y-posList[b].y,2));
	}
}
