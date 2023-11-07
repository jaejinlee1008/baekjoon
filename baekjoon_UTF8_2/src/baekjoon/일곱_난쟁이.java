package baekjoon;

import java.util.PriorityQueue;
import java.util.Scanner;

public class 일곱_난쟁이 {
	static int N = 9;
	static int R = 7;
	static int[] output = new int[7];
	static int[] input;
	static PriorityQueue<Integer> pq = new PriorityQueue<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		input = new int[9];
		for(int i=0;i<9;i++) {
			input[i] = sc.nextInt();
		}
		comb(0,0,0);
		while(!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
	}
	private static void comb(int cnt, int start, int sum) {
		if(sum>100) return;
		if(cnt==R) {
			if(sum!=100) return;
			else {
				if(pq.size()>0) return;
				for(int i : output) {
					pq.add(i);
				}
				return;
			}
		}
		
		for(int i=start;i<N;i++) {
			output[cnt] = input[i];
			comb(cnt+1,i+1,sum+input[i]);
		}
	}
}
