package baekjoon;

import java.util.Scanner;

public class oven {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int Hour, Minute, time;
		Hour = scan.nextInt();
		Minute = scan.nextInt();
		time = scan.nextInt();
		
		Minute+=time;
		if(Minute>=60)
		{
			Hour += Minute/60;
			Minute%=60;
		}
		Hour%=24;
		System.out.println(Hour + " " + Minute);
	}
}
