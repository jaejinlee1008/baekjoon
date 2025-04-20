package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 수들의_합5 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int front=0;
		int end=0;
		int count=1;
		if(N%2==0) {
			front = N/2-1;
			end = N/2;
		}else {
			front = N/2;
			end = N/2+1;
		}
		while(front>0) {
			if(sum(front,end)==N) {
				count++;
				end--;
				front--;
			}else if(sum(front,end)>N) {
				end--;
			}else {
				front--;
			}
		}
		System.out.println(count);
	}
	public static int sum(int a, int b) {
		return ((b-a+1)*(a+b))/2;
	}
}
