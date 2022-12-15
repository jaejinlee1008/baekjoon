package baekjoonLoop;

import java.util.Scanner;

public class Plus_cycle {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int input=scan.nextInt();
		int front=input/10;
		int end=input%10;
		int newnum= (end*10)+((front+end)%10);
		int i=1;
		while(input!=newnum)
		{
			front=newnum/10;
			end=newnum%10;
			newnum=(end*10)+((front+end)%10);
			i++;
		}
		System.out.println(i);
	}
}
