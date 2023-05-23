package class2;

import java.util.Scanner;

public class 분해합 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int answer=0;
		for(int i=1;i<N;i++) {
			int sum=0;
			sum+=i;
			int tmp = i;
			while(tmp!=0) {
				sum+=tmp%10;
				tmp/=10;
			}
			if(sum==N) {
				answer = i;
				break;
			}
		}
		System.out.println(answer);
	}
}
