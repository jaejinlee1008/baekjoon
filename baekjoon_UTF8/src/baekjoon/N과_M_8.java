package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과_M_8 {
	static int N;
	static int M;
	static int[] input;
	static int[] output;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		input = new int[N];
		output = new int[M];
		for(int i=0;i<N;i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(input);
		perm(0,0);
	}
	private static void perm(int cnt,int start) {
		if(cnt==M) {
			System.out.println(Arrays.toString(output).substring(1,Arrays.toString(output).length()-1).replace(",", ""));
			return;
		}
		for(int i=start;i<N;i++) {
			output[cnt]=input[i];
			perm(cnt+1,i);
			
		}
	}
}
