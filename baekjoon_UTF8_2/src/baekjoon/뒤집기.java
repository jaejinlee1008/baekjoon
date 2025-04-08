package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 뒤집기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		int count0=0;
		int count1=0;
		char curr = S.charAt(0);
		if(curr=='1') {
			count1++;
		}else {
			count0++;
		}
		for(int i=1;i<S.length();i++) {
			if(curr!=S.charAt(i)) {
				curr=S.charAt(i);
				if(curr=='1') {
					count1++;
				}else {
					count0++;
				}
				
			}
		}
		if(count1==0||count0==0) {
			System.out.println(0);
		}else if(count1==count0){
			System.out.println(count0);
		}else{
			if(count1>count0) {
				System.out.println(count0);
			}else {
				System.out.println(count1);
			}
		}
		
	}

}
