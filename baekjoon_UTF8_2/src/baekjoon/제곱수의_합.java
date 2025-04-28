package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 제곱수의_합 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		for(int i=1;i<=N;i++) {
			arr[i] = Integer.MAX_VALUE;
		}
		arr[1] = 1;
		if(N>1) {
			
			for(int i=2;i<=(int)Math.floor(Math.sqrt((double)N));i++) {
				arr[(int)Math.pow(i, 2)] = 1;
			}
			
			for(int i=2;i<=N;i++) {
				for(int j=i-1;j>(i%2==0 ? i/2-1 : i/2);j--) {
					arr[i] = Math.min(arr[i], arr[j]+arr[i-j]);
				}
			}
		}
		System.out.println(arr[N]);
	}
}
