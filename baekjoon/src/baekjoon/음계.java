package baekjoon;

import java.util.Scanner;

public class 음계 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int firstNum=scan.nextInt();
		if(firstNum!=1&&firstNum!=8) {
			System.out.println("mixed");
		}else if(firstNum==1) {
			for(int i=2;i<=8;i++) {
				int nextNum=scan.nextInt();
				if(nextNum!=(++firstNum)) {
					System.out.println("mixed");
					return;
				}
			}
			System.out.println("ascending");
		}else if(firstNum==8) {
			for(int i=2;i<=8;i++) {
				int nextNum=scan.nextInt();
				if(nextNum!=(--firstNum)) {
					System.out.println("mixed");
					return;
				}
			}
			System.out.println("descending");
		}
	}
}
