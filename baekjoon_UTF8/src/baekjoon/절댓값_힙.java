package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 절댓값_힙 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				if(Math.abs(o1)!=Math.abs(o2)) {
					return Math.abs(o1)-Math.abs(o2);
				}else {
					return o1-o2;
				}
				
			}
			
		});
		for(int i=0;i<N;i++) {
			int input = Integer.parseInt(br.readLine());
			if(input==0&&!pq.isEmpty()) {
				bw.write(Integer.toString(pq.poll())+"\n");
			}else if(input==0&&pq.isEmpty()){
				bw.write("0\n");
			}else {
				pq.add(input);
			}
			
		}
		bw.flush();
	}
}
