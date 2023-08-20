package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 약수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		StringTokenizer st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
			int n = Integer.parseInt(st.nextToken());
			min = Math.min(min, n);
			max = Math.max(max, n);
		}
		long result = min*max;
		System.out.println(result);
	}
}
