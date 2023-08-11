package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백설_공주와_일곱_난쟁이 {
	static int[] arr = new int[9];
	static int[] result = new int[7];
	static int R=7;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0;i<9;i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		comb(0,0);
	}
	private static void comb(int cnt,int start) {
		if(cnt==R) {
			int sum=0;
			for(int i : result) {
				sum+=i;
			}
			if(sum==100) {
				for(int i : result) {
					System.out.println(i);
				}
			}
			return;
		}
		
		for(int i=start;i<9;i++) {
			result[cnt]=arr[i];
			comb(cnt+1,i+1);
		}
	}
}
