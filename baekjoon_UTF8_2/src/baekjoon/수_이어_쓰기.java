package baekjoon;

import java.util.Scanner;

public class 수_이어_쓰기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		long answer=0;
		int len=1;
		int num=10;
		for(int i=1;i<=N;i++) {
			if(i%num==0) {
				num*=10;
				len++;
			}
			answer+=len;
		}
		System.out.println(answer);
	}
}
