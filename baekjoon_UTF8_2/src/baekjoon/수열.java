package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 수열 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int max = Integer.MIN_VALUE;
		int sum = 0;
		st = new StringTokenizer(br.readLine());
		List<Integer> list = new ArrayList<>();
		for(int i=0;i<N;i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		int start = 0;
		int end = K-1;
		for(int i=start;i<=end;i++) {
			sum+=list.get(i);
		}
		max = sum;
		for(int i=K;i<N;i++) {
			sum += list.get(i)-list.get(i-K);
			max = Math.max(sum, max);
		}
		System.out.println(max);
	}
}
