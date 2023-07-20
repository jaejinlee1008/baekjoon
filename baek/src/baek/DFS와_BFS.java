package baek;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFS¿Í_BFS {
	public static int current=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		int[] output = new int[N];
		boolean[] visited = new boolean[N+1];
		Map<Integer,List<Integer>> map = new HashMap<>();
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if(map.containsKey(x)) {
				map.get(x).add(y);
			}else {
				List<Integer> list = new ArrayList<>();
				list.add(y);
				map.put(x,list);
			}
			if(map.containsKey(y)) {
				map.get(y).add(x);
			}else {
				List<Integer> list = new ArrayList<>();
				list.add(x);
				map.put(y,list);
			}
		}
		DFS(output,visited,map,V);
		for(int i : output) {
			if(i!=0) {
				bw.write(i + " ");
			}
		}
		bw.newLine();
		visited = new boolean[N+1];
		current=0;
		BFS(output,visited,map,V);
		for(int i : output) {
			if(i!=0) {
				bw.write(i + " ");
			}
		}
		bw.flush();
	}
	
	public static void DFS(int[] output,boolean[] visited, Map<Integer,List<Integer>> map, int start) {
		if(current==output.length) {
			return;
		}
		output[current] = start;
		visited[start] = true;
		if(map.get(start)!=null) {
			map.get(start).sort((o1,o2)->o1-o2);
			
			for(int i=0;i<map.get(start).size();i++) {
				
				if(!visited[map.get(start).get(i)]) {
					current++;
					DFS(output,visited,map,map.get(start).get(i));
				}
				
			}
		}
		
		
	}
	
	public static void BFS(int[] output,boolean[] visited, Map<Integer,List<Integer>> map, int start) {
		
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		
		while(!queue.isEmpty()&&current<output.length) {
			int node = queue.poll();
			if(!visited[node]) {
				output[current] = node;
				visited[node]=true;
				current++;
				if(map.get(node)!=null) {
					map.get(node).sort((o1,o2)->o1-o2);
					for(int i : map.get(node)) {
						if(!visited[i])
							queue.add(i);
					}
				}
				
			}
		}
		
	}
}
