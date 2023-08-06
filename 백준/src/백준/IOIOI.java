package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class IOIOI {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int len = Integer.parseInt(br.readLine());
		String input = br.readLine();

		Stack<Character> stack = new Stack<>();
		int count=0;
		int answer=0;
		for(int i=0;i<len;i++) {
			if(input.charAt(i)=='I') {
				if(stack.isEmpty()) {
					stack.add(input.charAt(i));
					count++;
				}else {
					if(stack.pop()=='I') {
						stack.add(input.charAt(i));
						count=1;
					}else {
						stack.add(input.charAt(i));
						count++;
					}
					
				}
				if(count==N+1) {
					answer++;
					count--;
				}
			}else {
				if(stack.isEmpty()) {
					count=0;
					continue;
				}
				else {
					if(stack.pop()=='I') {
						stack.add(input.charAt(i));
					}else {
						count=0;
					}
				}
			}
		}
		System.out.println(answer);
	}
}
