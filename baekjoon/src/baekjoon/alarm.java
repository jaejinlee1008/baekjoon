package baekjoon;

import java.util.Scanner;

public class alarm {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int Hour, Minute;
		Hour = scan.nextInt();
		Minute = scan.nextInt();
		
		if(Minute>=45)
		{
			Minute -= 45;
		}
		else if(Minute<45 && Hour>0)
		{
			Hour-=1;
			Minute = 60 - (45-Minute);
		}else if((Minute<45) && (Hour==0))
		{
			Hour=23;
			Minute = 60 - (45-Minute);
		}
		
		System.out.println(Hour + " " + Minute);
	}
}
