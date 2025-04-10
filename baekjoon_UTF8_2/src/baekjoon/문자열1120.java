package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 문자열1120 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String A = st.nextToken();
		String B = st.nextToken();
		int min = Integer.MAX_VALUE;
		int diff = B.length()-A.length();
		int Alen = A.length();
		if(B.indexOf(A)!=-1) {
			System.out.println(0);
			return;
		}
		if(diff==0) {
			min=0;
			for(int j=0;j<Alen;j++) {
				if(A.charAt(j)!=B.charAt(j)) {
					min++;
				}
			}
			System.out.println(min);
			return;
		}else {
			for(int i=0;i<=diff;i++) {
				int  num=0;
				for(int j=0;j<Alen;j++) {
					if(A.charAt(j)!=B.charAt(j+i)) {
						num++;
					}
				}
				min = Integer.min(min, num);
			}
			System.out.println(min);
		}
		
	}

}
