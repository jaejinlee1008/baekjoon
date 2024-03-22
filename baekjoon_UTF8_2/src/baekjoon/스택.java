package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 스택 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<String> stack = new Stack<>();
		for(int i=0;i<N;i++) {
			String input = br.readLine();
			if(input.startsWith("push")) {
				stack.add(input.split(" ")[1]);
			}else if(input.equals("pop")) {
				if(stack.isEmpty()) {
					System.out.println("-1");
				}else {
					System.out.println(stack.pop());
				}
			}else if(input.equals("size")) {
				System.out.println(stack.size());
			}else if(input.equals("empty")) {
				if(stack.isEmpty()) {
					System.out.println("1");
				}else {
					System.out.println("0");
				}
			}else if(input.equals("top")) {
				if(stack.isEmpty()) {
					System.out.println("-1");
				}else {
					System.out.println(stack.peek());
				}
			}
		}
	}
}
