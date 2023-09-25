package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ15666_0925_이재진 {
	static int N,M;
	static List<Integer> input;
	static Set<Integer> set = new HashSet<>();
	static int[] output;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		input = new ArrayList<>();
		
		output = new int[M];
		for(int i=0;i<N;i++) {
			int num = Integer.parseInt(st.nextToken());
			if(!set.contains(num)) {
				set.add(num);
				input.add(num);
			}
			
		}
		Collections.sort(input);
		comb(0,0);
	}
	private static void comb(int cnt,int start) {
		if(cnt==M) {
			System.out.println(Arrays.toString(output).replace("[", "").replace("]", "").replace(",", ""));
			return;
		}
		for(int i=start;i<input.size();i++) {
			output[cnt] = input.get(i);
			comb(cnt+1,i);
		}
	}
}
