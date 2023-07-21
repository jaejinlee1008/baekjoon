package baek;

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

public class 케빈_베이컨의_6단계_법칙 {
	public static int min = Integer.MAX_VALUE;
	public static int answer = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
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
				map.put(x, list);
			}
			if(map.containsKey(y)) {
				map.get(y).add(x);
			}else {
				List<Integer> list = new ArrayList<>();
				list.add(x);
				map.put(y, list);
			}
		}
		for(int i=1;i<=N;i++) {
			boolean[] visited = new boolean[N+1];
			BFS(map,visited,i);
		}
		System.out.println(answer);
	}
	public static void BFS(Map<Integer,List<Integer>> map,boolean[] visited,int start) {
		Queue<int[]> queue = new LinkedList<>();
		
		queue.add(new int[] {start,1});
		visited[start] = true;
		int count=0;
		while(!queue.isEmpty()) {
			int[] arr = queue.poll();
			for(int i : map.get(arr[0])) {
				if(!visited[i]) {
					visited[i]=true;
					count+=arr[1];
					queue.add(new int[] {i,arr[1]+1});
				}
			}
		}
		if(count<min) {
			min = count;
			answer = start;
		}
	}
}
