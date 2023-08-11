package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2230_0811_이재진 {
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N+1];
		for(int i=1;i<=N;i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		int left=1;
		int right=2;
		while(left<right) {
			if(arr[right]-arr[left]==M) {
				System.out.println(M);
				return;
			}else if(arr[right]-arr[left]<M){
				if(right==N) {
					break;
				}
				right++;
			}else {
				min = Math.min(min, arr[right]-arr[left]);
				if(left+1==right&&right==N) {
					break;
				}
				if(left+1==right&&right<N) {
					right++;
					left++;
				}else if(left+1<right){
					left++;
				}
				
			}
		}
		System.out.println(min);
	}
	
}
