package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 크로아티아_알파벳 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] arr = br.readLine().toCharArray();
		int answer = arr.length;
		for(int i=1;i<arr.length;i++) {
			if(arr[i]=='-') {
				if(arr[i-1]=='c'||arr[i-1]=='d') {
					answer--;
				}
			}else if(arr[i]=='=') {
				if(arr[i-1]=='c'||arr[i-1]=='s') {
					answer--;
				}else if(arr[i-1]=='z') {
					if(i<2) {
						answer--;
					}else {
						if(arr[i-2]=='d') {
							answer-=2;
						}else {
							answer--;
						}
					}
				}
			}else if(arr[i]=='j') {
				if(arr[i-1]=='l'||arr[i-1]=='n') {
					answer--;
				}
			}else {
				
			}
		}
		System.out.println(answer);
	}
}
