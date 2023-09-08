package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 아 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = br.readLine().length();
		int b = br.readLine().length();
		if(a>=b) {
			System.out.println("go");
		}else {
			System.out.println("no");
		}
	}
}
