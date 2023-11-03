package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 평균_점수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sum=0;
		for(int i=0;i<5;i++) {
			int score = Integer.parseInt(br.readLine());
			if(score<40) score = 40;
			sum+=score;
		}
		System.out.println(sum/5);
	}
}
