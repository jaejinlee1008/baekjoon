package baekjoon;

import java.util.PriorityQueue;

public class 셀프넘버 {
	public static void main(String[] args) {
		
		boolean[] arr = new boolean[10001];

		for(int i=1;i<=10000;i++) {
			if(arr[i]) continue;
			PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
			pq.add(i);
			while(!pq.isEmpty()) {
				int n = pq.poll();
				if(n>10000) break;
				int tmp=n;
				
				while(n>=10) {
					tmp+=n%10;
					n/=10;
				}
				tmp+=n;
				if(tmp<10001&&!arr[tmp]) {
					pq.add(tmp);
					arr[tmp] = true;
				}
				
			}
		}
		
		for(int i=1;i<=10000;i++) {
			if(!arr[i]) {
				System.out.println(i);
			}
		}
	}
}
