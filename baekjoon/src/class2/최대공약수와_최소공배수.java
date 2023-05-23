package class2;

import java.util.Scanner;

public class 최대공약수와_최소공배수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int a = Math.max(num1, num2);
		int b = Math.min(num1, num2);
		
		while(b!=0) {
			int tmp = a%b;
			a=b;
			b=tmp;
		}
		System.out.println(a);
		System.out.println(a*(num1/a)*(num2/a));
		
	}
}
