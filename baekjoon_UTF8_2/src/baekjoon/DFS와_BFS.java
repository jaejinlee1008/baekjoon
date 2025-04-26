package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class DFS와_BFS {
	public static List<Integer>[] graph;
	public static int count;
	public static int[] output;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N+1];
		for(int i=0;i<graph.length;i++) {
			graph[i] = new ArrayList<>();
		}
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
		}
		boolean[] visited = new boolean[N+1];
		count=0;
		output = new int[N];
		DFS(visited,V);
		for(int i : output) {
			
		}
	}
	public static void DFS(boolean[] visited,int start) {
		if(count==output.length) {
			return;
		}
		visited[start] = true;
		output[count] = start;
		count++;
		for(int i=0;i<graph[start].size();i++) {
			if(!visited[graph[start].get(i)]) {
				DFS(visited,graph[start].get(i));
			}
		}
		
	}
}
