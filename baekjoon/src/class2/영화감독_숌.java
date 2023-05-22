package class2;

import java.util.Scanner;

public class 영화감독_숌 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[sc.nextInt()];
		int i=0;
		int idx=0;
		while(true) {
			if(idx==arr.length) break;
			if(Integer.toString(i).contains("666")) {
				arr[idx]=i;
				idx++;
			}
			i++;
		}
		System.out.println(arr[arr.length-1]);
	}
}
