package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class 최소비용_구하기2 {
	static int n,m;
	static class Edge implements Comparable<Edge>{
		int to;
		int weight;
		public Edge(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(weight, o.weight);
		}
		
	}
	static int start,end;
	static List<Edge>[] edgeList;
	static int[] before;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		edgeList = new List[n+1];
		for(int i=1;i<=n;i++) {
			edgeList[i] = new ArrayList<>();
		}
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			edgeList[a].add(new Edge(b,w));
			//edgeList[b].add(new Edge(a,w));
		}
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		int result = dijkstra();
		Stack<Integer> stack = new Stack<>();
		int num = end;
		int cnt=0;
		while(true) {
			cnt++;
			if(num == start) {
				stack.add(num);
				break;
			}
			stack.add(num);
			num = before[num];
		}
		System.out.println(result);
		System.out.println(cnt);
		while(!stack.isEmpty()) {
			System.out.print(stack.pop()+" ");
		}
	}
	private static int dijkstra() {
		boolean[] visited = new boolean[n+1];
		int[] dist = new int[n+1];
		before = new int[n+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(start,0));
		dist[start]=0;
		while(!pq.isEmpty()) {
			Edge e = pq.poll();
			if(visited[e.to]) continue;
			visited[e.to] = true;
			for(Edge next : edgeList[e.to]) {
				if(dist[next.to]>dist[e.to]+next.weight) {
					dist[next.to] = dist[e.to]+next.weight;
					pq.add(new Edge(next.to,dist[next.to]));
					before[next.to] = e.to;
				}
			}
		}
		return dist[end];
	}
}
