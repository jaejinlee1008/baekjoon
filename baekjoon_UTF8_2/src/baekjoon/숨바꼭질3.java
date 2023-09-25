package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 숨바꼭질3 {
	static int N,K;
	static boolean[] visited = new boolean[100001];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int result = bfs();
		System.out.println(result);
	}
	private static int bfs() {
		Deque<int[]> dq = new LinkedList<>();
		dq.add(new int[] {N,0});
		int result=0;
		while(!dq.isEmpty()) {
			int[] tmp = dq.poll();
			if(visited[tmp[0]]) continue;
			visited[tmp[0]] = true;
			if(tmp[0]==K) {
				result = tmp[1];
				break;
			}
			
			int nx = tmp[0]*2;
			if(nx<=100000&&!visited[nx]) {
				
				dq.addFirst(new int[] {nx,tmp[1]});
			}
			
			nx = tmp[0] + 1;
			if (nx <= 100000 && !visited[nx]) {
				
				dq.addLast(new int[] { nx, tmp[1]+1 });
			}

			nx = tmp[0] - 1;
			if (nx >= 0 && !visited[nx]) {
				
				dq.addLast(new int[] { nx, tmp[1]+1 });
			}
			
			
			
			
		}
		return result;
	}
}
