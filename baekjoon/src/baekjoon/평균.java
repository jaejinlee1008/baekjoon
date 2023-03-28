package baekjoon;

import java.util.Scanner;

public class 평균 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int test_case = scan.nextInt();
		int[] arr = new int[test_case];
		double[] darr = new double[test_case];
		int max=0;
		double sum=0;
		for(int i=0;i<test_case;i++) {
			arr[i] = scan.nextInt();
			if(max<arr[i]) {
				max=arr[i];
			}
		}
		for(int i=0;i<test_case;i++) {
			darr[i]=(arr[i]/(double)max)*100;
			sum+=darr[i];
		}
		System.out.println(sum/test_case);
	}
}
