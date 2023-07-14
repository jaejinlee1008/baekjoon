package baek;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Hashing {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int L = Integer.parseInt(br.readLine());
		String str = br.readLine();
		long answer=0;
		long l=1;
		for(int i=0;i<str.length();i++) {
			
			answer+=((str.charAt(i)-'a'+1)*l)%1234567891;
			l*=31;
			l=l%1234567891;
			answer%=1234567891;
		}
		bw.write(Long.toString(answer));
		bw.flush();
	}
}
