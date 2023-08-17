package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 트리의_지름 {
	static class Edge{
		int to;
		int weight;
		
		public Edge(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
		
	}
	static int V;
	static ArrayList<Edge>[] list;
	static boolean[] visited;
	static int max = Integer.MIN_VALUE;
	static int node;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine().trim());
		list = new ArrayList[V+1];
		
		
		for(int i=1;i<=V;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			int idx = Integer.parseInt(st.nextToken());
			list[idx]=new ArrayList<>();
			
			while(true) {
				int num = Integer.parseInt(st.nextToken());
				if(num==-1) {
					break;
				}
				int weight = Integer.parseInt(st.nextToken());
				list[idx].add(new Edge(num,weight));
			}
			
		}
		visited = new boolean[V+1];
		DFS(1,0); //임의의 노드에서 가장 먼 노드 찾기
		
		visited = new boolean[V+1];
		DFS(node,0); //가장 먼 노드에서 출발해 가장 먼 노드까지 거리 구하기
		
		System.out.println(max);
	}
	private static void DFS(int x,int sum) {
		if(sum>max) {
			max=sum;
			node=x;
		}
		visited[x]=true;
		
		for(int i = 0; i < list[x].size(); i++) {
            Edge e = list[x].get(i);
            if(!visited[e.to]) {
                DFS(e.to, e.weight + sum);
                visited[e.to] = true;
            }
        }
	}
}
