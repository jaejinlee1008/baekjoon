package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ2212_1016_이재진 {
	static class Node implements Comparable<Node>{
		int a;
		int b;
		int len;
		
		public Node(int a, int b, int len) {
			super();
			this.a = a;
			this.b = b;
			this.len = len;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(o.len, this.len);
		}

		@Override
		public String toString() {
			return "Node [a=" + a + ", b=" + b + ", len=" + len + "]";
		}
		
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		if(K>N) {
			System.out.println(0);
			return;
		}
		Arrays.sort(arr);
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		for(int i=0;i<N-1;i++) {
			pq.add(new Node(i,i+1,arr[i+1]-arr[i]));
		}
		boolean[] cut = new boolean[N-1];
		for(int i=0;i<K-1;i++) {
			cut[pq.poll().a] = true;
		}
		int sum=0;
		for(int i=0;i<N-1;i++) {
			
			if(cut[i]) {
				continue;
			}else {
				sum += arr[i+1]-arr[i];
				
			}
		}
		System.out.println(sum);
	}
}
