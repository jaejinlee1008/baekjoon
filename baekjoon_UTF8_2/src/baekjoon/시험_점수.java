package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 시험_점수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int sum1 = 0;
		int sum2=0;
		while(st.hasMoreTokens()) {
			sum1+=Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
			sum2+=Integer.parseInt(st.nextToken());
		}
		System.out.println(Math.max(sum1, sum2));
	}
}
