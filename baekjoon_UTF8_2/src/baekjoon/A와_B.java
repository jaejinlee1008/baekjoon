package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class A와_B {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		String T = br.readLine();
		Deque<Character> dq = new LinkedList<>();
		boolean reverse = false;
		for(char c : T.toCharArray()) {
			dq.add(c);
		}
		while(!dq.isEmpty()) {
			if(dq.size()==S.length()) {
				break;
			}
			if(!reverse) {
				if(dq.peekLast()=='A') {
					dq.pollLast();
				}else {
					dq.pollLast();
					reverse=!reverse;
				}
			}else {
				if(dq.peekFirst()=='A') {
					dq.pollFirst();
				}else {
					dq.pollFirst();
					reverse=!reverse;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		if(reverse) {
			while(!dq.isEmpty()) {
				sb.append(dq.pollLast());
			}
		}else {
			while(!dq.isEmpty()) {
				sb.append(dq.pollFirst());
			}
		}
		if(sb.toString().equals(S)) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
	}
}
