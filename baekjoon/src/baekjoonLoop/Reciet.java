package baekjoonLoop;

import java.util.Scanner;

public class Reciet {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int sum = scan.nextInt();
		int testcase = scan.nextInt();
		int price, num;
		int mySum=0;
		for(int i=0;i<testcase;i++)
		{
			price=scan.nextInt();
			num = scan.nextInt();
			mySum += price*num;
		}
		if(sum==mySum)
		{
			System.out.println("Yes");
		}else
		{
			System.out.println("No");
		}
	}
}
