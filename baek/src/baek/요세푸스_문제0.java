package baek;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class 요세푸스_문제0 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = sc.nextInt();
		int K = sc.nextInt();
		Deque<Integer> dq = new LinkedList<>();
		for(int i=1;i<=N;i++) {
			dq.add(i);
		}
		bw.write("<");
		while(dq.size()>1) {
			for(int i=1;i<K;i++) {
				dq.addLast(dq.poll());
			}
			bw.write(dq.poll()+", ");
		}
		bw.write(dq.poll()+">");
		bw.flush();
	}
}
