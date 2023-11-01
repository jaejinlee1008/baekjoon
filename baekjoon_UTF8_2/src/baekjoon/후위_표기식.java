package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 후위_표기식 {
	static class Pair{
		char op;
		int level;
		public Pair(char op, int level) {
			super();
			this.op = op;
			this.level = level;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		Stack<Character> stack = new Stack<>();
		Stack<Pair> operator = new Stack<>();
		int cnt=0;
		for(int i=0;i<input.length();i++) {
			if(cnt>0) {
				if(input.charAt(i)=='+'||input.charAt(i)=='-') {
					while(!operator.isEmpty()) {
						if(operator.peek().level<cnt) break;
						stack.push(operator.pop().op);
					}
					operator.push(new Pair(input.charAt(i),cnt));
					continue;
				}else if(input.charAt(i)=='*'||input.charAt(i)=='/') {
					while(!operator.isEmpty()) {
						if(operator.peek().level<cnt) break;
						if(operator.peek().level==cnt&&(operator.peek().op=='+'||operator.peek().op=='-')) break;
						stack.push(operator.pop().op);
					}
					operator.push(new Pair(input.charAt(i),cnt));
					continue;
				}
				
			}
			if(input.charAt(i)=='+'||input.charAt(i)=='-') {
				while(!operator.isEmpty()) {
					stack.push(operator.pop().op);
				}
				operator.push(new Pair(input.charAt(i),-1));
			}else if(input.charAt(i)=='*'||input.charAt(i)=='/') {
				while(!operator.isEmpty()) {
					if(operator.peek().level<0) break;
					stack.push(operator.pop().op);
				}
				operator.push(new Pair(input.charAt(i),0));
			}else if(input.charAt(i)=='(') {
				cnt++;
			}else if(input.charAt(i)==')') {
				cnt--;
			}else if(input.charAt(i)>='A'&&input.charAt(i)<='Z'){
				stack.push(input.charAt(i));
			}
		}
		while(!operator.isEmpty()) {
			stack.push(operator.pop().op);
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<stack.size();i++) {
			sb.append(stack.get(i));
		}
		System.out.println(sb.toString());
		
	}
}
