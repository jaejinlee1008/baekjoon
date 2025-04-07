package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 막대기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		char[] binary = Integer.toBinaryString(num).toCharArray();
		
		int answer = 0;
		for(int i=0;i<binary.length;i++) {
			if(binary[i]-'0' == 1) {
				answer++;
			}
		}
		bw.write(String.valueOf(answer));
		bw.flush();
	}

}
