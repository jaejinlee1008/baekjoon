package solved.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Á¦·Î {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long k = Long.parseLong(br.readLine());
		Stack<Long> stack = new Stack<>();
		for(long i=0;i<k;i++) {
			String str = br.readLine();
			if(!str.equals("0")) {
				stack.add(Long.parseLong(str));
			}else {
				stack.pop();
			}
		}
		long sum=0;
		while(!stack.isEmpty()) {
			sum+=stack.pop();
		}
		System.out.println(sum);
	}
}
