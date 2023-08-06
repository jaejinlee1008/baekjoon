package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class 최대_힙 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		for(int i=0;i<N;i++) {
			int n = Integer.parseInt(br.readLine());
			if(n==0) {
				if(pq.isEmpty()) {
					bw.write("0\n");
				}else {
					bw.write(Integer.toString(pq.poll())+"\n");
				}
			}else {
				pq.add(n);
			}
		}
		bw.flush();
	}
}
