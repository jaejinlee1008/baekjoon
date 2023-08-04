package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 나무_자르기 {
	static int N;
	static int M;
	static int max=Integer.MIN_VALUE;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(arr[i], max);
		}
		int low=0;
		int high=max;
		int mid=0;
		int answer=0;
		while(low<=high) {
			mid = (low+high)/2;
			long count=0;
			for(int i:arr) {
				if(i>mid) {
					count+=(i-mid);
				}
			}
			if(M<=count) {
				low = mid+1;
				if(mid>=answer) {
					answer=mid;
				}
			}else {
				high=mid-1;
			}
		}
		System.out.println(answer);
	}
}
