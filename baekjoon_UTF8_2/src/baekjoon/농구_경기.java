package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 농구_경기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] alpha = new int[26];
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			alpha[str.charAt(0)-'a']++;
		}
		boolean flag = true;
		for(int i=0;i<26;i++) {
			if(alpha[i]>=5) {
				bw.write(('a'+i));
				flag = false;
			}
		}
		
		if(flag) {
			bw.write("PREDAJA");
		}
		bw.flush();
	}
}
