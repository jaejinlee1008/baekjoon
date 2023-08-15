package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16953 {
	static int B;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		DFS(A,0);
		if(min==Integer.MAX_VALUE) {
			System.out.println("-1");
		}else {
			System.out.println(min+1);
		}
	}
	private static void DFS(long cur,int cnt) {
		if(cur==B) {
			min = Math.min(min, cnt);
			return;
		}else if(cur>B) {
			return;
		}
		DFS(cur*2,cnt+1);
		DFS((cur*10)+1,cnt+1);
	}
}
