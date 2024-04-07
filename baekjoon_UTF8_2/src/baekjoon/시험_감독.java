package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 시험_감독 {
	static int N;
	static int[] A;
	static int B,C;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		for(int i=0;i<N;i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		long answer=0;
		for(int i=0;i<N;i++) {
			if(A[i]<=B) {
				answer++;
				continue;
			}else {
				int rest = A[i]-B;
				if(rest%C==0) {
					answer+=rest/C + 1;
				}else {
					answer+=rest/C + 2;
				}
			}
		}
		System.out.println(answer);
	}
}
