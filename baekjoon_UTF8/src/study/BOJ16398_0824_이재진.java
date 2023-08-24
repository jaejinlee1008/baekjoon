package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ16398_0824_이재진 {
	static class Edge{
		int from;
		int to;
		int weight;
		
		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
		
	}
	static int N;
	static int[][] arr;
	static List<Edge> edgeList;
	static int[] parents;
	
	static void make() {
		parents = new int[N];
		for(int i=0;i<N;i++) {
			parents[i] = i;
		}
	}
	static int find(int a) {
		if(a==parents[a]) return a;
		return parents[a] = find(parents[a]);
	}
	static boolean union(int a, int b) {
		int aroot = find(a);
		int broot = find(b);
		if(aroot==broot) return false;
		parents[broot] = aroot;
		return true;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		edgeList = new ArrayList<>();
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(i<j) {
					edgeList.add(new Edge(i,j,arr[i][j]));
				}
			}
		}
		Collections.sort(edgeList, new Comparator<Edge>() {

			@Override
			public int compare(Edge o1, Edge o2) {
				return o1.weight-o2.weight;
			}
			
		});
		make();
		long sum=0;
		int cnt=0;
		for(Edge e : edgeList) {
			if(union(e.from,e.to)) {
				sum+=e.weight;
				if(++cnt==N-1) break;
			}
		}
		System.out.println(sum);
	}
}
