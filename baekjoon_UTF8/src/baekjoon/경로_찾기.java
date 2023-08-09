package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class 경로_찾기 {
	static Map<Integer,List<Integer>> map;
	static int N;
	static int[][] arr;
	static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		map = new HashMap<>();
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				int n = Integer.parseInt(st.nextToken());
				if(n==1) {
					if(map.containsKey(i)) {
						map.get(i).add(j);
					}else {
						List<Integer> list = new ArrayList<>();
						list.add(j);
						map.put(i, list);
					}
				}
			}
		}
//		System.out.println(map);
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				visited = new boolean[N];
				arr[i][j]=BFS(i,j);
			}
		}
		
		for(int[] ar : arr) {
			bw.write(Arrays.toString(ar).substring(1,Arrays.toString(ar).length()-1).replace(",", "")+"\n");
		}
		bw.flush();
	}
	private static int BFS(int start,int end) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
//		visited[start]=true;
		while(!queue.isEmpty()) {
			int num = queue.poll();
			if(map.containsKey(num)) {
				for(int i : map.get(num)) {
					if(i==end) {
						return 1;
					}else {
						if(!visited[i]) {
							queue.add(i);
							visited[i]=true;
						}
						
					}
				}
			}else {
				continue;
			}
			
		}
		return 0;
	}
}
