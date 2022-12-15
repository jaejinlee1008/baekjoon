package baekjoonLoop;

import java.util.Scanner;

public class PrintStar_2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int count = scan.nextInt();
		for(int i=1;i<=count;i++)
		{
			for(int j=count;j>0;j--)
			{
				if(j<=i)
				{
					System.out.print("*");
				}else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
}
