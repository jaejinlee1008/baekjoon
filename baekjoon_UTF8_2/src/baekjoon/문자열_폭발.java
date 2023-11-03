package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 문자열_폭발 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String target = br.readLine();
		int ilen = input.length();
		int tlen = target.length();
		Stack<Character> stack = new Stack<>();
		for(int i=0;i<ilen;i++) {
			stack.push(input.charAt(i));
			
			if(stack.size()>=tlen) {
				boolean flag=true;
				for(int j=0;j<tlen;j++) {
					if(stack.get(stack.size()-tlen+j)!=target.charAt(j)) {
						flag=false;
						break;
					}
				}
				if(flag) {
					for(int j=0;j<tlen;j++) {
						stack.pop();
					}
				}
			}
		}
		if(stack.isEmpty()) {
			System.out.println("FRULA");
			return;
		}else {
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<stack.size();i++) {
				sb.append(stack.get(i));
			}
			System.out.println(sb.toString());
			return;
		}
		
	}
}
