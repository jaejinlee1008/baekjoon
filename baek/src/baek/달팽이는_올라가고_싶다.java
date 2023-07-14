package baek;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 달팽이는_올라가고_싶다 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		long V = Long.parseLong(st.nextToken());
		
		long len=0;
		long day=0;
		long onenight = A-B;
		day = (V-A)/onenight;
		if(((V-A)%onenight)==0) {
			day++;
		}else {
			day+=2;
		}
		bw.write(Long.toString(day));
		bw.flush();
	}
}
