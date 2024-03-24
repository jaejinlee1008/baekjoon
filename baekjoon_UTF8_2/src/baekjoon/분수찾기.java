package baekjoon;

import java.util.Scanner;

public class 분수찾기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();
		int i = 1;
		int sum=1;
		while(true) {
			if(X>sum) {
				sum+=++i;
			}else {
				break;
			}
		}
		int before = sum-i;
		int seq = X-before;
		if(i%2==0) {
			int a = seq;
			int b = i+1-a;
			System.out.println(a+"/"+b);
		}else {
			int a = seq;
			int b = i+1-a;
			System.out.println(b+"/"+a);
		}
	}
}
