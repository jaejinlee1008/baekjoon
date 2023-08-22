package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 트리의_부모_찾기 {
	static int N;
	static ArrayList<Integer>[] arr;
	static boolean[] visited;
	static Map<Integer,Integer> map = new HashMap<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		arr = new  ArrayList[N+1];
		visited = new boolean[N+1];
		for(int i=1;i<=N;i++) {
			arr[i] = new ArrayList<>();
		}
		for(int i=0;i<N-1;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			arr[from].add(to);
			arr[to].add(from);
		}
		DFS(1);
		for(int i=2;i<=N;i++) {
			bw.write(map.get(i)+"\n");
		}
		bw.flush();
	}
	private static void DFS(int n) {
		visited[n]=true;
		ArrayList<Integer> tmp = arr[n];
		for(int i : tmp) {
			if(!visited[i]) {
				map.put(i, n);
				DFS(i);
			}
		}
		return;
	}
}
