package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class 연결_요소의_개수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Map<Integer,List<Integer>> map = new HashMap<>();
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(map.containsKey(a)) {
				map.get(a).add(b);
			}else {
				List<Integer> list = new ArrayList<>();
				list.add(b);
				map.put(a, list);
			}
			
			if(map.containsKey(b)) {
				map.get(b).add(a);
			}else {
				List<Integer> list = new ArrayList<>();
				list.add(a);
				map.put(b, list);
			}
		}
		boolean[] visited = new boolean[N+1];
		int count=0;
		for(int i=1;i<=N;i++) {
			if(visited[i]) {
				continue;
			}
			Queue<Integer> queue = new LinkedList<>();
			queue.add(i);
			visited[i]=true;
			while(!queue.isEmpty()) {
				int n = queue.poll();
				if(map.get(n)!=null) {
					for(int e : map.get(n)) {
						if(!visited[e]) {
							queue.add(e);
							visited[e]=true;
						}
					}
				}
			}
			count++;
		}
		System.out.println(count);
	}
}
