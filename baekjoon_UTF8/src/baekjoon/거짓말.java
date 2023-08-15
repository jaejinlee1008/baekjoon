package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class 거짓말 {
	static int N;
	static int M;
	static Queue<Integer> tr = new LinkedList<>();
	static List<Set<Integer>> party = new LinkedList<>();
	static boolean[] visited = new boolean[51];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		for(int i=0;i<n;i++) {
			int tmp = Integer.parseInt(st.nextToken());
			tr.add(tmp);
		}
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			Set<Integer> tmp = new HashSet<>();
			for(int j=0;j<n;j++) {
				tmp.add(Integer.parseInt(st.nextToken()));
			}
			party.add(tmp);
		}
		while(!tr.isEmpty()) {
			int find = tr.poll();
			visited[find]=true;
			Iterator<Set<Integer>> iter = party.iterator();
			while(iter.hasNext()) {
				Set<Integer> tmp = (Set<Integer>)iter.next();
				if(tmp.contains(find)) {
					for(int i : tmp) {
						if(!visited[i]) tr.add(i);
					}
					iter.remove();
				}
			}
		}
		System.out.println(party.size());
	}
}
