package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과_M_4 {
	static int N;
	static int M;
	static int[] numbers;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		numbers = new int[M];
		duperm(0,1);
	}
	private static void duperm(int cnt,int start) {
		if(cnt==M) {
			System.out.println(Arrays.toString(numbers).substring(1,Arrays.toString(numbers).length()-1).replace(",", ""));
			return;
		}
		for(int i=start;i<=N;i++) {
			numbers[cnt]=i;
			duperm(cnt+1,i);
		}
	}
}
