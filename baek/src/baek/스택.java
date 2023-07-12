package baek;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Ω∫≈√ {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		Stack<String> stack = new Stack<>();
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			if(str.startsWith("push")) {
				stack.push(str.split(" ")[1]);
			}else if(str.equals("top")) {
				if(!stack.isEmpty()) {
					bw.write(stack.peek());
				}else {
					bw.write("-1");
				}
				bw.flush();
				bw.newLine();
			}else if(str.equals("size")) {
				bw.write(Integer.toString(stack.size()));
				bw.flush();
				bw.newLine();
			}else if(str.equals("empty")) {
				if(stack.isEmpty()) {
					bw.write("1");
				}else {
					bw.write("0");
				}
				bw.flush();
				bw.newLine();
			}else if(str.equals("pop")) {
				if(!stack.isEmpty()) {
					bw.write(stack.pop());
				}else {
					bw.write("-1");
				}
				bw.flush();
				bw.newLine();
			}
			
		}
	}
}
