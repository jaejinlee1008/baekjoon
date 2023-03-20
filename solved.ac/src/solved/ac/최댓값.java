package solved.ac;

import java.util.Scanner;

public class ÃÖ´ñ°ª {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int max=0;
		int num=0;
		int input=0;
		for(int i=1;i<=9;i++) {
			input = scan.nextInt();
			if(input>max) {
				max=input;
				num=i;
			}
		}
		System.out.println(max);
		System.out.println(num);
	}
}
