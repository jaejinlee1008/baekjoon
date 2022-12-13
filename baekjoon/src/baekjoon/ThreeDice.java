package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class ThreeDice {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int arr[]=new int[3];
		int result=0;
		arr[0]=scan.nextInt();
		arr[1]=scan.nextInt();
		arr[2]=scan.nextInt();
		
		if((arr[0]==arr[1])&&(arr[1]==arr[2]))
		{
			result = 10000 + arr[0]*1000;
			System.out.println(result);
		}else if(arr[0]==arr[1]||arr[1]==arr[2]||arr[0]==arr[2])
		{
			if(arr[0]==arr[1])
			{
				result = 1000 + arr[0]*100;
			}else if(arr[1]==arr[2])
			{
				result = 1000 + arr[1]*100;
			}else if(arr[0]==arr[2])
			{
				result = 1000 + arr[0]*100;
			}
			System.out.println(result);
		}else
		{
			Arrays.sort(arr);
			result = arr[2]*100;
			System.out.println(result);
		}
	}
}
