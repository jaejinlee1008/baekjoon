package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class N과_M_9 {
	static int N;
	static int M;
	static int[] input;
	static boolean[] visited;
	static int[] output;
	static Set<String> set = new HashSet<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		input = new int[N];
		visited = new boolean[N];
		output = new int[M];
		for(int i=0;i<N;i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(input);
		perm(0);
	}
	private static void perm(int cnt) {
		if(cnt==M) {
			String str = Arrays.toString(output);
			if(!set.contains(str)) {
				set.add(str);
				System.out.println(str.substring(1,str.length()-1).replace(",", ""));
			}
			
			return;
		}
		for(int i=0;i<N;i++) {
			if(!visited[i]) {
				visited[i]=true;
				output[cnt]=input[i];
				perm(cnt+1);
				visited[i]=false;
			}
			
			
		}
	}
}
