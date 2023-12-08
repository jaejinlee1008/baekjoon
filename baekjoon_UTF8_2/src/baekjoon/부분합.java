package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부분합 {
	static int N,S;
	static int[] arr;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int left=0;
		int right=0;
		long sum=0;
		sum = arr[left];
		while(left<=right) {
			if(sum<S) {
				if(right<N-1) {
					sum+=arr[++right];
				}else {
					break;
				}
			}else if(sum>=S) {
				min = Math.min(min, right-left+1);
				if(left<right) {
					sum-=arr[left++];
				}else if(left==right){
					if(right<N-1) {
						left++;
						right++;
						sum=arr[left];
					}else {
						break;
					}
				}else {
					break;
				}
			}
		}
		if(min==Integer.MAX_VALUE) {
			System.out.println(0);
		}else {
			System.out.println(min);
		}
		
	}
}
