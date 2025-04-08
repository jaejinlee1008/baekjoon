package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 뒤집기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		int answer=1;
		char curr = S.charAt(0);
		for(int i=1;i<S.length();i++) {
			if(curr!=S.charAt(i)) {
				curr=S.charAt(i);
				answer++;
			}
		}
		System.out.println(answer/2);
		
	}

}
