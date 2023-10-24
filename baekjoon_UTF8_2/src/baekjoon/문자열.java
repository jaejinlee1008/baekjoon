package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = null;
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			sb = new StringBuilder();
			String str = br.readLine();
			sb.append(str.charAt(0));
			sb.append(str.charAt(str.length()-1));
			System.out.println(sb.toString());
		}
	}
}
