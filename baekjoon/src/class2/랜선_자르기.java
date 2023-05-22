package class2;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class 랜선_자르기 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		int n = sc.nextInt();
		int[] arr = new int[k];
		for(int i=0;i<k;i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		long max = arr[k-1];
		long min = 1;
		long middle = 0;
		while(max>=min) {
			middle = (max+min)/2;
			
			long count = 0;
			for(int j=0;j<k;j++) {
				count+=arr[j]/middle;
			}
			if(count>=n) {
				min = middle+1;
			}else if(count<n) {
				max = middle-1;
			}
//			System.out.println(count + ", " + min + ", " + max);
		}
		System.out.println(max);
	}
}
