package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 트리의_지름 {
	static int V;
	static boolean[] visited;
	static List<int[]>[] list;
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine());
		visited = new boolean[V+1];
		list = new List[V+1];
		for(int i=1;i<=V;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			list[i] = new ArrayList<>();
			int idx = Integer.parseInt(st.nextToken());
//			visited[idx]=true;
			while(true) {
				int num = Integer.parseInt(st.nextToken());
				if(num==-1) {
					break;
				}
				int weight = Integer.parseInt(st.nextToken());
				list[i].add(new int[] {num,weight});
			}
			
		}
		for(List<int[]> l : list) {
			if(l!=null) {
				for(int[] ar : l) {
					System.out.println(Arrays.toString(ar));
				}
			}
			
		}
		visited = new boolean[V+1];
		for(int i=1;i<=V;i++) {
			if(!visited[i]) {
				visited[i]=true;
//				DFS(i,0);
			}
		}
		System.out.println(max);
	}
	private static void DFS(int row,int sum) {
		if(list[row].size()==0) {
			max = Math.max(sum, max);
			return;
		}
		for(int[] ar : list[row]) {
			visited[ar[0]] = true;
			DFS(ar[0],sum+ar[1]);
		}
	}
}
