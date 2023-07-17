package solved.ac;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class ±ÕÇüÀâÈù_¼¼»ó {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while(true) {
			String str = br.readLine();
			if(!str.equals(".")) {
				Stack<Character> stack = new Stack<>();
				for(char c : str.toCharArray()) {
					if(c=='('||c=='[') {
						stack.add(c);
					}else if(c==')') {
						if(!stack.isEmpty()&&stack.peek()=='(') {
							stack.pop();
						}else {
							bw.write("no");
							bw.newLine();
							break;
						}
					}else if(c==']') {
						if(!stack.isEmpty()&&stack.peek()=='[') {
							stack.pop();
						}else {
							bw.write("no");
							bw.newLine();
							break;
						}
					}else if(c=='.') {
						stack.add(c);
					}
				}
				if(stack.size()==1&&stack.peek()=='.') {
					bw.write("yes");
					bw.newLine();
				}else if(!stack.isEmpty()&&stack.peek()=='.'&&stack.size()>1) {
					bw.write("no");
					bw.newLine();
				}
			}else {
				break;
			}
			
		}
		bw.flush();
	}
}
