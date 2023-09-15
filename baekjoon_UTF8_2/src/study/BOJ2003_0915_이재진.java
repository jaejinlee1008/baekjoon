package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2003_0915_이재진 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] A = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			A[i] = Integer.parseInt(st.nextToken())+A[i-1];
		}
		int left=0;
		int right=1;
		int cnt=0;
		while(true) {
			if(right==N&&A[right]-A[left]<=M) {
				if(A[right]-A[left]==M) cnt++;
				break;
			}
			if(A[right]-A[left]<M) {
				if(right<N) {
					right++;
				}
			}else if(A[right]-A[left]>M){
				if(left<right) {
					left++;
				}
			}else {
				cnt++;
				if(right<N) {
					right++;
				}
			}
		}
		System.out.println(cnt);
	}
}
