package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 풍선_터뜨리기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Deque<int[]> list = new ArrayDeque<>();
		for(int i=1;i<=N;i++) {
			int[] arr = {i,Integer.parseInt(st.nextToken())};
			list.add(arr);
		}
		int idx=0;
		while(list.size()>0) {
			int[] cur = new int[2];
			if(idx>0) {
				for(int i=0;i<idx;i++) {
					list.addLast(list.poll());
				}
			}else {
				for(int i=idx;i<0;i++) {
					list.addFirst(list.pollLast());
				}
			}
			
			cur = list.poll();
			bw.write(Integer.toString(cur[0])+" ");
			if(cur[1]>0) {
				idx = cur[1]-1;
			}else {
				idx = cur[1];
			}
		}
		bw.flush();
	}
}
