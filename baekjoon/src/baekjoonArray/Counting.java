package baekjoonArray;

import java.util.Scanner;

public class Counting {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int count=0;
		int val;
		int num=scan.nextInt();
		int arr[]=new int[num];
		for(int i=0;i<num;i++)
		{
			arr[i]=scan.nextInt();
		}
		val=scan.nextInt();
		for(int i=0;i<num;i++)
		{
			if(val==arr[i])
			{
				count++;
			}
			
		}
		System.out.println(count);
	}
}
