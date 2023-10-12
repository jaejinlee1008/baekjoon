package study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BOJ21939_1012_이재진 {
	static class Problem implements Comparable<Problem>{
		int num;
		int lev;
		public Problem(int num, int lev) {
			super();
			this.num = num;
			this.lev = lev;
		}
		
		@Override
		public int compareTo(Problem o) {
			if(this.lev==o.lev) {
				return this.num-o.num;
			}
			return this.lev-o.lev;
		}
		
		
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		TreeSet<Problem> set = new TreeSet<>();
		Map<Integer,Integer> map = new HashMap<>();
 		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			set.add(new Problem(a, b));
			map.put(a, b);
		}
		int M = Integer.parseInt(br.readLine());
		for(int i=0;i<M;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			if(cmd.equals("add")) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				map.put(a, b);
				set.add(new Problem(a,b));
			}else if(cmd.equals("recommend")) {
				int a = Integer.parseInt(st.nextToken());
				if(a==1) {
					bw.write(set.last().num+"\n");
				}else {
					bw.write(set.first().num+"\n");
				}
			}else {
				int a = Integer.parseInt(st.nextToken());
				set.remove(new Problem(a,map.get(a)));
				map.remove(a);
			}
		}
		bw.flush();
	}
}
