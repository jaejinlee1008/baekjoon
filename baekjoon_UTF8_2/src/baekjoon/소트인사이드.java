package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 소트인사이드 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int[] arr = new int[10];
		for(char c : input.toCharArray()) {
			arr[c-'0']++;
		}
		StringBuilder sb = new StringBuilder();
		for(int i=9;i>=0;i--) {
			for(int j=1;j<=arr[i];j++) {
				sb.append(i);
			}
		}
		System.out.println(sb.toString());
	}
}
