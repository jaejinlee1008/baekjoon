package solved.ac;

import java.util.Scanner;

public class 직사각형에서_탈출 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt();
		int y = scan.nextInt();
		int w = scan.nextInt();
		int h = scan.nextInt();
		int answer = 0;
		answer = Math.min(Math.min(w-x, x),Math.min(h-y, y));
		System.out.println(answer);
	}
}
