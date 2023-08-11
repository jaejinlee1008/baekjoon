package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 치킨_배달 {
	static int N;
	static int M;
	static int[][] dosi;
	static List<int[]> list1 = new ArrayList<>();
	static List<int[]> list2 = new ArrayList<>();
	static int min = Integer.MAX_VALUE;
	static boolean[] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		dosi = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				dosi[i][j] = Integer.parseInt(st.nextToken());
				if(dosi[i][j]==1) {
					list1.add(new int[] {i,j});
				}else if(dosi[i][j]==2) {
					list2.add(new int[] {i,j});
				}
			}
		}
		visited = new boolean[list2.size()];
		subset(0,0);
		System.out.println(min);
	}
	private static void subset(int cnt,int select) {
		
		if(cnt==list2.size()&&select<=M&&select>0) {
			
			int sum=0;
			for(int i=0;i<list1.size();i++) {
				int num=Integer.MAX_VALUE;
				for(int j=0;j<list2.size();j++) {
					if(visited[j]) {
						int n = Math.abs(list1.get(i)[0]-list2.get(j)[0])+Math.abs(list1.get(i)[1]-list2.get(j)[1]);
						num = Math.min(num, n);
					}
				}
				sum+=num;
			}
			min = Math.min(sum, min);
			return;
		}
		if(cnt==list2.size()) return;
		visited[cnt]=true;
		subset(cnt+1,select+1);
		visited[cnt]=false;
		subset(cnt+1,select);
	}
	
}
