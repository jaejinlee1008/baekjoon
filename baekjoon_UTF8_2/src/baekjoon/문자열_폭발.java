package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 문자열_폭발 {
	static String target;
	static int tarlen;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		target = br.readLine();
		tarlen = target.length();
		
		String result = recur(input);
		if(result.length()==0) {
			System.out.println("FRULA");
		}else {
			System.out.println(result);
		}
	}
	private static String recur(String input) {
		if(!input.contains(target)) {
			return input;
		}
		int cnt=0;
		Stack<Character> stack = new Stack<>();
		for(int i=0;i<input.length();i++) {
			
			if(input.charAt(i)==target.charAt(cnt)) {
				cnt++;
			}else {
				if(cnt!=0) {
					i--;
					cnt=0;
					continue;
				}
				cnt=0;
			}
			stack.push(input.charAt(i));
			if(cnt==tarlen) {
				for(int j=0;j<tarlen;j++) {
					stack.pop();
				}
				cnt=0;
			}
		}
		
		return recur(stack.toString().replace(" ", "").replace(",", "").replace("[", "").replace("]", ""));
		
	}
}
