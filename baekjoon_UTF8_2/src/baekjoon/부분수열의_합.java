package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부분수열의_합 {
	static int N,S;
	static int[] input;
	static int result;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		input = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		visited = new boolean[N];
		subset(0,0);
		System.out.println(result);
	}
	private static void subset(int cnt,int pick) {
		if(cnt==N&&pick>0) {
			int sum=0;
			for(int i=0;i<N;i++) {
				if(visited[i]) {
					sum+=input[i];
				}
			}
			if(sum==S) {
				result++;
			}
			return;
		}
		if(cnt==N) return;
		visited[cnt]=true;
		subset(cnt+1,pick+1);
		visited[cnt]=false;
		subset(cnt+1,pick);
	}
	
}
