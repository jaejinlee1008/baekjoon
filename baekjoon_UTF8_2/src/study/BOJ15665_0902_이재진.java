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

public class BOJ15665_0902_이재진 {
	static int N,M;
	static List<Integer> input;
	static Set<Integer> set = new HashSet<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		input = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			int num = Integer.parseInt(st.nextToken());
			if(set.contains(num)) continue;
			input.add(num);
			set.add(num);
		}
		Collections.sort(input);
		System.out.println(Math.round(10.222));
//		perm(0,new int[M]);
	}
	private static void perm(int cnt,int[] output) {
		if(cnt==M) {
			System.out.println(Arrays.toString(output).replace("[", "").replace("]", "").replace(",", ""));
			return;
		}
		for(int i=0;i<input.size();i++) {
			output[cnt] = input.get(i);
			perm(cnt+1,output);
		}
	}
}
