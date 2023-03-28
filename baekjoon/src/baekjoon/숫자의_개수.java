package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 숫자의_개수 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
		int sum=1;
		try {
			for(int i=0;i<3;i++) {
				sum *= Integer.parseInt(br.readLine());
			}
			String str = Integer.toString(sum);
			for(int i=0;i<10;i++) {
				System.out.println((str.length()-str.replace(Integer.toString(i), "").length()));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
