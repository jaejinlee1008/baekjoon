package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class 줄_세우기 {
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<Integer> graph[] = new ArrayList[N+1];
		visited = new boolean[N+1];
		for(int i=1;i<=N;i++) {
			graph[i] = new ArrayList<>();
		}
		int[] degree = new int[N+1];
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			degree[to]++;
			graph[from].add(to);
		}
		Queue<int[]> queue = new LinkedList<>();
		Map<Integer,Integer> map = new HashMap<>();
		int len=0;
		for(int i=1;i<=N;i++) {
			if(degree[i]==0) {
				queue.add(new int[] {i,len});
				map.put(i, len);
			}
		}
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			sb.append(current+" ");
			ArrayList<Integer> tmp = graph[current[0]];
			for(int i : tmp) {
				degree[i]--;
				if(degree[i]==0) {
					queue.add(new int[] {i,current[1]+1});
					map.put(i, current[1]+1);
				}
			}
		}
		System.out.println(sb);
	}
}
