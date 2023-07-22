package solved.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class ÀÒ¾î¹ö¸°_°ýÈ£ {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		Queue<String> queue = new LinkedList<>();
		for(String s : input.split("-")) {
			queue.add(s);
		}
		int answer=0;
		if(queue.peek().contains("+")) {
			for(String s : queue.poll().split("\\+")) {
				answer += Integer.parseInt(s);
			}
		}else {
			answer +=Integer.parseInt(queue.poll());
		}
		
		while(!queue.isEmpty()) {
			int tmp = 0;
			if(queue.peek().contains("+")) {
				for(String s : queue.poll().split("\\+")) {
					tmp += Integer.parseInt(s);
				}
			}else {
				tmp = Integer.parseInt(queue.poll());
			}
			
			answer -= tmp;
		}
		System.out.println(answer);
	}
}
