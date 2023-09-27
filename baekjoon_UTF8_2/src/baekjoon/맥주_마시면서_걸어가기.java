package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 맥주_마시면서_걸어가기 {
	static int plus = 32768;
	static List<int[]> cu;
	static boolean[] visited;
	static int[] start; 
	static int[] end; 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int tc=0;tc<t;tc++) {
			int N = Integer.parseInt(br.readLine());
			start = new int[2];
			end = new int[2];
			cu = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			start[0] = Integer.parseInt(st.nextToken());
			start[1] = Integer.parseInt(st.nextToken());
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				cu.add(new int[] {x,y});
			}
			visited = new boolean[cu.size()];
			st = new StringTokenizer(br.readLine());
			end[0] = Integer.parseInt(st.nextToken());
			end[1] = Integer.parseInt(st.nextToken());
			if(bfs()) {
				System.out.println("happy");
			}else {
				System.out.println("sad");
			}
		}
	}
	private static boolean bfs() {
		boolean flag=false;
		Queue<int[]> queue = new LinkedList<>();
		queue.add(start);
		while(!queue.isEmpty()) {
			int[] tmp = queue.poll();
			if(Math.abs(end[0]-tmp[0])+Math.abs(end[1]-tmp[1])<=1000) {
				flag = true;
				break;
			}
			for(int i=0;i<cu.size();i++) {
				if(Math.abs(cu.get(i)[0]-tmp[0])+Math.abs(cu.get(i)[1]-tmp[1])<=1000&&!visited[i]) {
					visited[i]=true;
					queue.add(cu.get(i));
				}
			}
		}
		return flag;
	}
}
