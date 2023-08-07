package baekjoon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 요세푸스_문제 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		Queue<Integer> queue = new LinkedList<>();
		for(int i=1;i<=N;i++) {
			queue.add(i);
		}
		int idx=0;
		int[] result = new int[N];
		while(!queue.isEmpty()) {
			for(int i=0;i<K-1;i++) {
				queue.add(queue.poll());
			}
			result[idx++] = queue.poll();
		}
		StringBuilder sb = new StringBuilder();
		sb.append("<").append(Arrays.toString(result).substring(1,Arrays.toString(result).length()-1)).append(">");
		System.out.println(sb.toString());
	}
}
