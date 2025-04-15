package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 회전하는_큐 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		LinkedList<Integer> deq = new LinkedList<>();
		for(int i=1;i<=N;i++) {
			deq.offer(i);
		}
		int count=0;
		int half=0;
		for(int i=0;i<M;i++) {
			int target = deq.indexOf(arr[i]);
			if(deq.size()%2==0) {
				half=(deq.size()/2)-1;
			}else {
				half=deq.size()/2;
			}
			if(target<=half) {
				for(int j=0;j<target;j++) {
					int temp = deq.pollFirst();
					deq.offerLast(temp);
					count++;
				}
			}else {
				for(int j=0;j<deq.size()-target;j++) {
					int temp = deq.pollLast();
					deq.offerFirst(temp);
					count++;
				}
			}
			deq.pollFirst();
		}
		System.out.println(count);
	}
}
