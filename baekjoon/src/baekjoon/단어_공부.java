package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class 단어_공부 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input="";
		try {
			input = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String newstr = input.toUpperCase();
		System.out.println(newstr);
		StringBuilder sb = new StringBuilder();
		Set<Character> set = new HashSet<>();
		for(char c : newstr.toCharArray()) {
			if(set.add(c)) {
				sb.append(c);
			}
		}
		String deduplication =sb.toString();
		System.out.println(deduplication);
		int count=0;
		int max=0;
		String result ="";
		for(int i=0;i<deduplication.length();i++) {
			count = newstr.length()-(newstr.replace(deduplication.substring(i, i+1), "")).length();
			if(max<count)
			{
				max=count;
				result=deduplication.substring(i, i+1);
			}else if(max==count) {
				result="?";
			}
		}
		System.out.println(result);
	}
}
