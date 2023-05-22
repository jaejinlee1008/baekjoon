package class2;

import java.util.Scanner;

public class 소수_찾기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int count=0;
		for(int i=0;i<N;i++) {
			count++;
			int num = sc.nextInt();
			if(num==1) {
				count--;
				continue;
			}
			for(int j=2;j<=Math.sqrt(num);j++) {
				if(num%j==0) {
					count--;
					break;
				}
			}
		}
		System.out.println(count);
	}
}
