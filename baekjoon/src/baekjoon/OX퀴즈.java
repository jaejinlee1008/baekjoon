package baekjoon;

import java.util.Scanner;

public class OX퀴즈 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testcase=Integer.parseInt(scan.nextLine());
		for(int j=0;j<testcase;j++) {
			String input = scan.nextLine();
			int score=0;
			int pluspoint=0;
			for(int i=0;i<input.length();i++) {
				if(input.charAt(i)=='O') {
					pluspoint++;
				}else {
					pluspoint=0;
				}
				score+=pluspoint;
			}
			System.out.println(score);
		}
		
	}
}
