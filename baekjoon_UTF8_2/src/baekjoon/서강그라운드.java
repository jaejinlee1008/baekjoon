package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 서강그라운드 {
	static int n,m,r;
	static int[] items;
	static int INF = Integer.MAX_VALUE;
//	static class Edge{
//		int to;
//		int weight;
//		
//		public Edge(int to, int weight) {
//			super();
//			this.to = to;
//			this.weight = weight;
//		}
//	}
//	static List<Edge>[] edgeList;
	static int[][] Edge;
	static int sum=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		items = new int[n+1];
		Edge = new int[n+1][n+1];
		for(int i=1;i<=n;i++) {
			Arrays.fill(Edge[i], INF);
		}
//		edgeList = new List[n+1];
//		for(int i=1;i<=n;i++) {
//			edgeList[i] = new ArrayList<>();
//		}
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=n;i++) {
			items[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=0;i<r;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			Edge[a][b]=w;
			Edge[b][a]=w;
//			edgeList[a].add(new Edge(b,w));
//			edgeList[b].add(new Edge(a,w));
		}
		
		int result = 0;
		for(int k=1;k<=n;k++) {
			for(int i=1;i<=n;i++) {
				if(i==k) continue;
				for(int j=1;j<=n;j++) {
					if(j==k||i==j) continue;
					if(Edge[i][k]==INF||Edge[k][j]==INF) continue;
					if(Edge[i][j]>Edge[i][k]+Edge[k][j]) {
						Edge[i][j] = Edge[i][k]+Edge[k][j];
					}
				}
			}
		}
		for(int i=1;i<=n;i++) {
			int sum=items[i];
			for(int j=1;j<=n;j++) {
				if(Edge[i][j]<=m) {
					sum+=items[j];
				}
			}
			result = Math.max(sum, result);
		}
		
		System.out.println(result);
	}
	
}
