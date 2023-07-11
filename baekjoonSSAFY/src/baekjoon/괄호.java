package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class °ýÈ£ {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		for(int i=0;i<num;i++) {
			String s = br.readLine();
			Stack<Character> stack = new Stack<>();
			for(char c : s.toCharArray()) {
				if(stack.isEmpty()) {
					stack.add(c);
				}else {
					if(c=='(') {
						stack.add(c);
					}else {
						if(stack.peek()=='(') {
							stack.pop();
						}
					}
				}
			}
			if(stack.size()==0) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		}
	}
}
