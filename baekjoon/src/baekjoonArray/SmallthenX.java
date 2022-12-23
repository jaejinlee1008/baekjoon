package baekjoonArray;

import java.util.Scanner;

public class SmallthenX {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num=scan.nextInt();
		int val=scan.nextInt();
		int arr[]=new int[num];
		for(int i=0;i<num;i++)
		{
			
			arr[i]=scan.nextInt();
		}
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]<val)
				System.out.print(arr[i]+ " ");
		}
	}
}
