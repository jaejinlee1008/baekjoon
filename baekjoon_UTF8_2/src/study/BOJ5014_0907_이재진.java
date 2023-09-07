package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ5014_0907_이재진 {
	static int F,S,G,U,D;
	static boolean[] visited;
	static int result=-1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		if(S==G) {
			System.out.println(0);
			return;
		}
		visited = new boolean[F+1];
		bfs();
		if(result==-1) {
			System.out.println("use the stairs");
		}else {
			System.out.println(result);
		}
		
	}
	private static void bfs() {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {S,0});
		visited[S] = true;
		while(!queue.isEmpty()) {
			int[] tmp = queue.poll();
			if(tmp[0]==G) {
				result = tmp[1];
				return;
			}
			int nx = tmp[0]+U;
			if(nx>=1&&nx<=F&&!visited[nx]) {
				visited[nx]=true;
				queue.add(new int[] {nx,tmp[1]+1});
			}
			nx = tmp[0]-D;
			if(nx>=1&&nx<=F&&!visited[nx]) {
				visited[nx]=true;
				queue.add(new int[] {nx,tmp[1]+1});
			}
		}
	}
}
