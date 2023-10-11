package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 숨바꼭질2 {
	static int N,K;
	static boolean[] visited;
	static class Case{
		int cur;
		int cnt;
		boolean[] visited;
		
		public Case(int cur, int cnt, boolean[] visited) {
			super();
			this.cur = cur;
			this.cnt = cnt;
			this.visited = visited;
		}
		
	}
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		if(N==K) {
			System.out.println(0);
			System.out.println(1);
		}else if(N>K) {
			System.out.println(N-K);
			System.out.println(1);
		}else {
		
			visited = new boolean[K*2];
			
			int cnt = bfs();
			System.out.println(min);
			System.out.println(cnt);
		}
	}
	private static int bfs() {
		int cnt=0;
		Queue<Case> queue = new LinkedList<>();
		queue.add(new Case(N,0,new boolean[K*2]));
		while(!queue.isEmpty()) {
			Case c = queue.poll();
			c.visited[c.cur]=true;
			if(c.cur==K) {
				if(min>c.cnt) {
					min=c.cnt;
					cnt=1;
				}else if(min==c.cnt) {
					cnt++;
				}
				continue;
			}
			int nx = c.cur*2;
			if(nx>=0&&nx<K*2&&!c.visited[nx]) {
				queue.add(new Case(nx,c.cnt+1,c.visited));
			}
			
			nx = c.cur+1;
			if(nx>=0&&nx<K*2&&!c.visited[nx]) {
				queue.add(new Case(nx,c.cnt+1,c.visited));
			}
			
			nx = c.cur-1;
			if(nx>=0&&nx<K*2&&!c.visited[nx]) {
				queue.add(new Case(nx,c.cnt+1,c.visited));
			}
		}
		return cnt;
	}
}
