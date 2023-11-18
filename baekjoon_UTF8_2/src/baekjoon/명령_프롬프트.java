package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 명령_프롬프트 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[] str = br.readLine().toCharArray();
		for(int i=1;i<N;i++) {
			char[] tmp = br.readLine().toCharArray();
			for(int j=0;j<tmp.length;j++) {
				if(str[j]!=tmp[j]) {
					str[j] = '?';
				}
			}
			
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<str.length;i++) {
			sb.append(str[i]);
		}
		System.out.println(sb.toString());
	}
}
