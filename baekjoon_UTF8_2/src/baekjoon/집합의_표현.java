package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 집합의_표현 {
	public static int N;
	public static int[] parents;
	
	private static void make() {
		parents = new int[N+1];
		for(int i=0;i<=N;i++) {
			parents[i] = i;
		}
	}
	
	private static int find(int a) {
		if(a==parents[a]) return a;
		return parents[a] = find(parents[a]);
	}
	
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot==bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		make();
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int num=Integer.parseInt(st.nextToken());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			if(num==0) {
				union(a,b);
			}else {
				if(find(a)==find(b)) {
					bw.write("yes");
				}else {
					bw.write("no");
				}
				bw.newLine();
			}
		}
		bw.flush();
	}
}
