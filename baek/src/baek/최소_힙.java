package baek;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class ÃÖ¼Ò_Èü {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			if(str.equals("0")) {
				if(pq.isEmpty()) {
					bw.write("0");
					bw.newLine();
				}else {
					bw.write(Integer.toString(pq.poll()));
					bw.newLine();
				}
			}else {
				pq.add(Integer.parseInt(str));
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
