package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class 게리맨더링 {
	static class Edge{
		int from;
		int to;
		
		public Edge(int from, int to) {
			this.from = from;
			this.to = to;
		}
		
	}
	static int N;
	static int[] arr;
	static ArrayList<Integer>[] adjList;
	static Map<Integer,List<Integer>> map = new HashMap<>();
	static boolean[] visited;
	static int sum1,sum2;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N+1];
		visited = new boolean[N+1];
		for(int i=1;i<=N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		adjList = new ArrayList[N+1];
		for(int i=1;i<=N;i++) {
			adjList[i]=new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			for(int j=0;j<n;j++) {
				int num = Integer.parseInt(st.nextToken());
				adjList[i].add(num);
				if(map.containsKey(i)) {
					map.get(i).add(num);
				}else {
					List<Integer> list = new ArrayList<>();
					list.add(num);
					map.put(i, list);
				}
			}
		}
		subset(1,0);
		if(min==Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(min);
		}
	}
	private static void subset(int cnt,int pick) {
		if(cnt==N+1&&pick>0&&pick<N) {
			int[] arr1 = new int[pick+1];
			int[] arr2 = new int[(N-pick)+1];
			int idx1=1;
			int idx2=1;
			for(int i=1;i<=N;i++) {
				if(visited[i]) {
					arr1[idx1++] = i;
				}else {
					arr2[idx2++] = i;
				}
			}
			if(check(arr1)&&check(arr2)) {
//				System.out.println("통과");
				for(int i : arr1) {
					sum1+=arr[i];
				}
				for(int i : arr2) {
					sum2+=arr[i];
				}
				min = Math.min(Math.abs(sum1-sum2), min);
				sum1=0;
				sum2=0;
			}
			return;
		}
		if(cnt==N+1) {
			return;
		}
		visited[cnt]=true;
		subset(cnt+1,pick+1);
		visited[cnt]=false;
		subset(cnt+1,pick);
	}
	private static boolean check(int[] node) {
//		System.out.println(Arrays.toString(node));
		if(node.length==2) return true;
		boolean[] btmp = new boolean[N+1];
		for(int i=1;i<node.length;i++) {
			btmp[node[i]] = true;
		}
		for(int i : node) {
			if(i!=0) {
				dfs(i,node,btmp);
				break;
			}
		}
//		System.out.println(Arrays.toString(btmp));
		for(boolean b : btmp) {
			if(b) return false;
		}
		return true;
	}
	private static void dfs(int x, int[] node,boolean[] b) {
		b[x]=false;
		ArrayList<Integer> list = adjList[x];
		for(int i : list) {
			if(b[i]) {
				for(int j : node) {
					if(i==j) {
						dfs(i,node,b);
					}
				}
			}
			
		}
	}
}
