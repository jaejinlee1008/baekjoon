package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class 그룹_단어_체커 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int answer = 0;
		for(int i=0;i<N;i++) {
			String input = br.readLine();
			char[] arr = input.toCharArray();
			Set<Character> set = new HashSet<>();
			set.add(arr[0]);
			boolean flag = false;
			for(int j=1;j<arr.length;j++) {
				if(arr[j]==arr[j-1]) continue;
				if(!set.contains(arr[j])) {
					set.add(arr[j]);
				}else {
					flag = true;
				}
			}
			if(!flag) {
				answer++;
			}
		}
		System.out.println(answer);
	}
}
