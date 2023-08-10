package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1629_0810_이재진 {
	static int A;
	static int B;
	static int C;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		System.out.println(pow(A,B));
	}
	private static long pow(long A,long B) {
		if(B==1) {
			return A%C;
		}
		long num = pow(A,B/2);
		if(B%2==0) {
			return num*num%C;
		}else {
			return (num*num%C)*A%C;
		}
	}
}
