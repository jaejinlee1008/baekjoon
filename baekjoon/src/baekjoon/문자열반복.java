package baekjoon;

import java.util.Scanner;

public class 문자열반복 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testcase=scan.nextInt();
		
		for(int i=0;i<testcase;i++) {
			int num = scan.nextInt();
			String str1 = scan.next();
			for(int j=0;j<str1.length();j++)
			{
				for(int k=0;k<num;k++)
				{
					System.out.print(str1.charAt(j));
				}
			}
			System.out.println("");
		}
	}
}
