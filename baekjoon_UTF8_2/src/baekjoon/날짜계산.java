package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 날짜계산 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int E = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int i=E;
		
		if(S==28) {
			S=0;
		}
		if(M==19) {
			M=0;
		}
		while(true) {
			if(i%28!=S) {
				i+=15;
			}else {
				break;
			}
		}
		while(true) {
			if(i%19!=M) {
				i+=(15*28);
			}else {
				break;
			}
		}
		System.out.println(i);
	}

}
