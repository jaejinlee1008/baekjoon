package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 방_번호 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] input = new int[10];
		char[] arr = br.readLine().toCharArray();
		for(int i=0;i<arr.length;i++) {
			input[arr[i]-'0']++;
		}
		int max = (int)Math.ceil((input[6]+input[9])*0.5);
		for(int i=0;i<10;i++) {
			if(i==6||i==9) continue;
			if(input[i]>max) {
				max = input[i];
			}
		}
		System.out.println(max);
	}
}
