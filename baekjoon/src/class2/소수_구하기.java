package class2;

import java.util.Scanner;

public class 소수_구하기 {
	public static boolean[] isPrime;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int min = sc.nextInt();
		int max = sc.nextInt();
		prime(max);
		for(int i=min;i<=max;i++) {
			if(!isPrime[i]) {
				System.out.println(i);
			}
		}
	}
	public static void prime(int num) {
		isPrime = new boolean[num+1];
		isPrime[0] = true;
		isPrime[1] = true;
		if(num<=1) {
			return;
		}
		for(int i=2;i<=Math.sqrt(num);i++) {
			if(isPrime[i]) {
				continue;
			}else {
				for(int j=i*i;j<isPrime.length;j=j+i) {
					isPrime[j]=true;
				}
			}
		}
	}
}
