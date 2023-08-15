package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장_긴_증가하는_부분_수열2 {
	static int N;
	static int[] input;
	static int[] arr = new int[1000001];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		input = new int[N+1];
		int min=Integer.MAX_VALUE;
		for(int i=1;i<=N;i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		arr[1] = input[1];
		if(N==1) {
			System.out.println("1");
			return;
		}
		int len=1;
		for(int i=2;i<=N;i++) {
			if(arr[len]<input[i]) {
				arr[++len] = input[i];
			}else {
				int idx = binarySearch(0,len,input[i]);
				arr[idx] = input[i];
			}
		}
		System.out.println(len);
	}
	private static int binarySearch(int left, int right, int num) {
		int mid=0;
		while(left<right) {
//			System.out.println(left+","+right);
			mid = (left+right)/2;
			if(arr[mid]<num) {
				left = mid+1;
			}else {
				right = mid;
			}
		}
		return right;
	}

}
