package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ11000_0812_이재진 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0]-o2[0];
				
			}
		});
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			pq.add(new int[] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});
		}
		PriorityQueue<Integer> rooms = new PriorityQueue<Integer>();
		while(!pq.isEmpty()) {
			int[] tmp = pq.poll();
			if(!rooms.isEmpty()&&tmp[0]>=rooms.peek()) {
				rooms.poll();
			}
			rooms.add(tmp[1]);
		}
		System.out.println(rooms.size());
	}
	
	
}
