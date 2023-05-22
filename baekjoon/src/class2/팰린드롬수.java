package class2;

import java.util.Scanner;

public class 팰린드롬수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int num = sc.nextInt();
			if(num==0) break;
			String tmp = Integer.toString(num);
			
			StringBuilder sb = new StringBuilder(tmp);
			String reverse = sb.reverse().toString();
			if(tmp.compareTo(reverse)==0) {
				System.out.println("yes");
			}else {
				System.out.println("no");
			}
		}
	}
}
