package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class BOJ11478_0926_이재진 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int len = str.length();
		Set<String> set = new HashSet<>();
		for(int i=1;i<=len;i++) {
			int start=0;
			int end = start+i;
			while(end<=len) {
				set.add(str.substring(start, end));
				start++;
				end++;
			}
		}
		System.out.println(set.size());
	}
}
