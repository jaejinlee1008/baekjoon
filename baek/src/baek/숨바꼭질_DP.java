package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ¼û¹Ù²ÀÁú_DP {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int max = 100001;
		int[] arr = new int[max];
		
		if(N>=K) {
			System.out.println(N-K);
			return;
		}
		for(int i=0;i<N;i++) {
			arr[i] = N-i;
		}
		
		dp(arr,N,K);
		
		System.out.println(arr[K]);
	}
	
	public static void dp(int[] arr,int N,int K) {
		for(int i=N+1;i<=K;i++) {
			int min;
			if(i%2==0) {
				min = arr[i/2]+1;
			}else {
				min = Math.min(arr[(i+1)/2], arr[(i-1)/2])+2;
			}
			arr[i] = Math.min(min, arr[i-1]+1);
		}
	}
}
