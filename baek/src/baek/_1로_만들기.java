package baek;

import java.util.Scanner;

public class _1로_만들기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N+1];
		arr[1] = 0;
		for(int i=1;i<N+1;i++) {
			if(i*2<N+1) {
				if(arr[i*2]!=0) {
					arr[i*2] = Math.min(arr[i*2], arr[i]+1);
				}else {
					arr[i*2] = arr[i]+1;
				}
			}
			if(i*3<N+1) {
				if(arr[i*3]!=0) {
					arr[i*3] = Math.min(arr[i*3], arr[i]+1);
				}else {
					arr[i*3] = arr[i]+1;
				}
			}
			if(i+1<N+1) {
				if(arr[i+1]!=0) {
					arr[i+1] = Math.min(arr[i+1], arr[i]+1);
				}else {
					arr[i+1] = arr[i]+1;
				}
			}
		}
//		if(N==2) {
//			arr[2]=1;
//		}else if(N>2) {
//			arr[2] = 1;
//			arr[3] = 1;
//			for(int i=4;i<N+1;i++) {
//				if(i%2==0&&i%3==0) {
//					arr[i] = Math.min(Math.min(arr[i-1], arr[i/2]),arr[i-3])+1;
//				}
//				else if(i%3==0) {
//					arr[i] = Math.min(arr[i-1], arr[i/3])+1;
//				}else if(i%2==0) {
//					arr[i] = Math.min(arr[i-1], arr[i/2])+1;
//				}
//				else {
//					arr[i] = arr[i-1]+1;
//				}
//				
//			}
//		}
		
		System.out.println(arr[N]);
	}
}
