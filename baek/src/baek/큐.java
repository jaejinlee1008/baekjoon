package baek;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;

public class ť {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		Deque<String> dq = new LinkedList<>();
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			if(str.startsWith("push")) {
				dq.add(str.split(" ")[1]);
			}else if(str.equals("front")) {
				if(!dq.isEmpty()) {
					bw.write(dq.peekFirst());
				}else {
					bw.write("-1");
				}
				bw.flush();
				bw.newLine();
			}else if(str.equals("back")) {
				if(!dq.isEmpty()) {
					bw.write(dq.peekLast());
				}else {
					bw.write("-1");
				}
				bw.flush();
				bw.newLine();
			}else if(str.equals("size")) {
				bw.write(Integer.toString(dq.size()));
				bw.flush();
				bw.newLine();
			}else if(str.equals("empty")) {
				if(dq.isEmpty()) {
					bw.write("1");
				}else {
					bw.write("0");
				}
				bw.flush();
				bw.newLine();
			}else if(str.equals("pop")) {
				if(!dq.isEmpty()) {
					bw.write(dq.poll());
				}else {
					bw.write("-1");
				}
				bw.flush();
				bw.newLine();
			}
			
		}
	}
}
