package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2217_0814_이재진 {
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] input = new int[N];
		for(int i=0;i<N;i++) {
			input[i]=Integer.parseInt(br.readLine());
		}
		Arrays.sort(input);
		for(int i=1;i<=N;i++) {
			max = Math.max(max, input[N-i]*i);
		}
		System.out.println(max);
	}
}
