package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 음악프로그램 {
	static int N, M;
	static List<Integer>[] list;
	static int[] ranks;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ranks = new int[N+1];
		list = new ArrayList[N+1];
		for(int i=1;i<=N;i++) {
			list[i] = new ArrayList<>();
		}
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int size = Integer.parseInt(st.nextToken());
			int first = Integer.parseInt(st.nextToken());
			for(int j=1;j<size;j++) {
				int second = Integer.parseInt(st.nextToken());
				list[first].add(second);
				ranks[second]++;
				first = second;
			}
		}
		
		List<Integer> result = topologysort();
		if(result.size()==N) {
			for(int i=0;i<result.size();i++) {
				System.out.println(result.get(i));
			}
		}else {
			System.out.println(0);
		}
		
		
	}
	public static List<Integer> topologysort(){
		Queue<Integer> queue = new LinkedList<>();
		for(int i=1;i<=N;i++) {
			if(ranks[i]==0) {
				queue.add(i);
			}
		}
		List<Integer> result = new ArrayList<>();
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			result.add(cur);
			for(int i=0;i<list[cur].size();i++) {
				int next = list[cur].get(i);
				ranks[next]--;
				if(ranks[next]==0) queue.add(next);
			}
		}
		return result;
	}
}
