package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ1759_0816_이재진 {
	static int L;
	static int C;
	static char[] input;
	static char[] output;
	static Set<Character> set = new HashSet<>(Arrays.asList('a','e','i','o','u'));
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		input = new char[C];
		output = new char[L];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<C;i++) {
			input[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(input);
		comb(0,0,0,0);
	}
	private static void comb(int cnt,int start,int cons,int vowel) { //재귀횟수,시작지점,자음갯수,모음갯수
		if(cnt==L) {
			if(cons>=2&&vowel>=1) {
				System.out.println(Arrays.toString(output).substring(1,Arrays.toString(output).length()-1).replace(",", "").replace(" ", ""));
				return;
			}else {
				return;
			}
		}
		for(int i=start;i<C;i++) {
			output[cnt]=input[i];
			if(set.contains(input[i])) {
				comb(cnt+1,i+1,cons,vowel+1);
			}else {
				comb(cnt+1,i+1,cons+1,vowel);
			}
			
		}
	}
}
