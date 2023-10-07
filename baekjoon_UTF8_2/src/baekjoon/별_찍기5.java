package baekjoon;

import java.util.Scanner;

public class 별_찍기5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for(int i=0;i<N;i++) {
			for(int j=1;j<=N;j++) {
				if(j>=N-i) {
					System.out.print("*");
				}else {
					System.out.print(" ");
				}
			}
			for(int j=N+1;j<N*2;j++) {
				if(j-N<=i) {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}
}
