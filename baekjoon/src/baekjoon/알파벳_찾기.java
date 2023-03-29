package baekjoon;

import java.util.Scanner;

public class 알파벳_찾기 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();
		int[] loc = new int[26];
		for(int i=0;i<26;i++) {
			loc[i] = -1;
		}
		for(int i=0;i<s.length();i++) {
			if(loc[(int)s.charAt(i)-97]==-1) {
				loc[(int)s.charAt(i)-97]=i;
			}
		}
		for(int i=0;i<26;i++) {
			System.out.print(loc[i]+" ");
		}
	}
}
