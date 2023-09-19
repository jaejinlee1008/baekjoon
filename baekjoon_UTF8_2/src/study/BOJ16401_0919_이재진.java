package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ16401_0919_이재진 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] input = new int[N+1];
		int max = Integer.MIN_VALUE;
		int min=1;
		for(int i=1;i<=N;i++) {
			input[i] = (Integer.parseInt(st.nextToken()));
			max = Math.max(max, input[i]);
		}
		int result=0;
		while(min<=max) {
			int cnt=0;
			int mid = (min+max)/2;
			if(mid==0) {
				break;
			}
			for(int i=1;i<=N;i++) {
				cnt+=input[i]/mid;
			}
			if(cnt>=M) {
				min = mid+1;
				result = Math.max(mid, result);
			}else {
				max = mid-1;
			}
		}
		System.out.println(result);
	}
	
}
