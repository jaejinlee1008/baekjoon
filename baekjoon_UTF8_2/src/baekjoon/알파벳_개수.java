package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 알파벳_개수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] s = br.readLine().toCharArray();
		int[] alpha = new int[26];
		for(int i=0;i<s.length;i++) {
			alpha[s[i]-'a']++;
		}
		for(int i=0;i<26;i++) {
			System.out.print(alpha[i]+" ");
		}
	}
}
