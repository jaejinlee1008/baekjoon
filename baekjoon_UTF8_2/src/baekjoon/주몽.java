package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 주몽 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		if(M>=200000) {
			System.out.println(0);
		}else {
			int[] arr = new int[N];
			Set<Integer> set = new HashSet<>();
			int count = 0;
			for(int i=0;i<N;i++) {
				int n = Integer.parseInt(st.nextToken());
				arr[i] = n;
				set.add(n);
			}
			for(int i=0;i<N;i++) {
				if(set.contains(M-arr[i])) {
					count++;
				}
			}
			System.out.println(count/2);
		}
		
		
	}
}
