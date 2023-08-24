package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 가장_긴_바이토닉_부분_수열 {
	static int len,max;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] input = new int[N+1];
		int[] dpmax = new int[N+1];
		int[] dpmin = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		dpmax[1]=1;
		dpmin[N]=0;
		if(N==1) {
			System.out.println(1);
			return;
		}
		
		for(int i=2;i<=N;i++) {
			int max=0;
			for(int j=1;j<i;j++) {
				if(input[j]<input[i]) {
					max=Math.max(dpmax[j], max);
				}
			}
			
			dpmax[i]=max+1;
		}
		for(int i=N-1;i>=1;i--) {
			int maxlen=0;
			boolean flag=false;
			for(int j=N;j>i;j--) {
				if(input[i]>input[j]) {
					maxlen=Math.max(maxlen, dpmin[j]);
					flag=true;
				}
			}
			if(flag) {
				dpmin[i]=maxlen+1;
			}else {
				dpmin[i]=0;
			}
			
		}
//		System.out.println(Arrays.toString(dpmax));
//		System.out.println(Arrays.toString(dpmin));
		int result=0;
		for(int i=1;i<N;i++) {
			result = Math.max(result, dpmax[i]+dpmin[i]);
		}
		System.out.println(result);
	}
}
