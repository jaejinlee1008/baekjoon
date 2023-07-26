package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ¼û¹Ù²ÀÁú {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int max = 100001;
		int[] arr = new int[max];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(N);
		while(!queue.isEmpty()) {
			int num = queue.poll();
			
			if(num==K) {
				break;
			}
			
			if(num-1>=0&&num-1<max) {
				if(arr[num-1]==0) {
					arr[num-1] = arr[num]+1;
					queue.add(num-1);
				}
				
			}
			if(num+1>=0&&num+1<max) {
				if(arr[num+1]==0) {
					arr[num+1] = arr[num]+1;
					queue.add(num+1);
				}
				
			}
			if(num*2>=0&&num*2<max) {
				if(arr[num*2]==0) {
					arr[num*2] = arr[num]+1;
					queue.add(num*2);
				}
				
			}
		}
		System.out.println(arr[K]);
	}
}
