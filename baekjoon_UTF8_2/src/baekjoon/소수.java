package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 소수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		double A = Double.parseDouble(st.nextToken());
		double B = Double.parseDouble(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		double div = A%B;
		
		for(int i=0;i<N-1;i++) {
			div*=10;
			div%=B;
		}
		System.out.println((int)((div/B)*10));
	}
}
