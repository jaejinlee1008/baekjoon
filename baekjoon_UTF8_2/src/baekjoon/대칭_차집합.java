package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 대칭_차집합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Set<Integer> set = new HashSet<>();
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		st = new StringTokenizer(br.readLine());
		int cnt=0;
		for(int i=0;i<M;i++) {
			int a = Integer.parseInt(st.nextToken());
			if(set.contains(a)) cnt++;
			set.add(a);
		}
		System.out.println(set.size()-cnt);
	}
}
