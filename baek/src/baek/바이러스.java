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

public class 바이러스 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int E = Integer.parseInt(br.readLine());
		int count=0;
		if(E>0) {
			Map<Integer,List<Integer>> map = new HashMap<>();
			boolean[] visited = new boolean[N+1];
			for(int i=0;i<E;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
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
			Queue<Integer> queue = new LinkedList<>();
			queue.add(1);
			visited[1]=true;
			
			while(!queue.isEmpty()) {
				List<Integer> tmp = map.get(queue.poll());
				for(int i : tmp) {
					if(!visited[i]) {
						count++;
						visited[i]=true;
						queue.add(i);
					}
				}
			}
		}
		
		System.out.println(count);
	}
}
