package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;
// DP는 순회하는 싸이클이 있을 경우 사용하기 힘듦
public class 뱀과_사다리_게임 {
	static int N;
	static int M;
	static int[] arr = new int[101];
	static int[] visited = new int[101];
	static Map<Integer,Integer> map = new HashMap<>();
	static Map<Integer,Integer> map2 = new HashMap<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		
		for(int i=0;i<N+M;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			map.put(start, end);
		}
//		for(int i=0;i<M;i++) {
//			st = new StringTokenizer(br.readLine());
//			int start = Integer.parseInt(st.nextToken());
//			int end = Integer.parseInt(st.nextToken());
//			map2.put(start, end);
//		}
		System.out.println(BFS(1));
	}
	
	private static int BFS(int start) {
		int num=0;
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {start,0});
		while(!queue.isEmpty()) {
			int[] tmp = queue.poll();
			if(tmp[0]==100) {
				num = tmp[1];
				break;
			}
			for(int i=1;i<=6;i++) {
				int next = tmp[0]+i;
				if(next>1&&next<=100&&visited[next]<2) {
					visited[next]++;
					if(map.containsKey(next)) {
						queue.add(new int[] {map.get(next),tmp[1]+1});
						visited[map.get(next)]++;
					}else {
						queue.add(new int[] {next,tmp[1]+1});
					}
				}
			}
		}
		return num;
	}
}
