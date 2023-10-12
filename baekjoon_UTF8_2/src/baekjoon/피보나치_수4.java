package baekjoon;

import java.math.BigInteger;
import java.util.Scanner;

public class 피보나치_수4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		BigInteger[] fibo = new BigInteger[N+1];
		fibo[0]=new BigInteger("0");
		fibo[1]=new BigInteger("1");
		fibo[2]=new BigInteger("1");
		if(N>=2) {
			for(int i=2;i<=N;i++) {
				fibo[i] = fibo[i-1].add(fibo[i-2]);
			}
		}
		System.out.println(fibo[N]);
	}
}
