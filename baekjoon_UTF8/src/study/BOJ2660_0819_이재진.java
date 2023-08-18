package study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2660_0819_이재진 {
	static int N;
	static ArrayList<Integer>[] list;
	static int[] score;
	static boolean[] visited;
	static int min = Integer.MAX_VALUE;
	static PriorityQueue<Integer> answer = new PriorityQueue<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine().trim());
		list = new ArrayList[N+1];
		score = new int[N+1];
		for(int i=1;i<=N;i++) {
			list[i] = new ArrayList<>();
		}
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			if(from==-1&&to==-1) break;
			list[from].add(to);
			list[to].add(from);
		}
		for(int i=1;i<=N;i++) {
			visited = new boolean[N+1];
			score[i] = BFS(i);
			min = Math.min(score[i], min);
		}
		for(int i=1;i<=N;i++) {
			if(score[i]==min) {
				answer.add(i);
			}
		}
		bw.write(min+" "+answer.size()+"\n");
		while(!answer.isEmpty()) {
			bw.write(answer.poll()+" ");
		}
		bw.flush();
	}
	private static int BFS(int idx) {
		Queue<int[]> queue = new LinkedList<>();
		int num=0;
		queue.add(new int[] {idx,0});
		visited[idx]=true;
		while(!queue.isEmpty()) {
			int[] tmp = queue.poll();
			for(int i : list[tmp[0]]) {
				if(!visited[i]) {
					visited[i]=true;
					queue.add(new int[] {i,tmp[1]+1});
					num=tmp[1]+1;
				}
			}
		}
		return num;
	}
}
