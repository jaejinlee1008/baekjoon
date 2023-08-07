package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 카잉_달력 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
//			int lcm = M*N/gcd(M,N); //최소공배수
//			int n=0;
			int ans=-1;
//			while(n*M<lcm){
//				if((n*M+x-y)%N==0) {
//					ans = n*M+x;
//					break;
//				}
//				n++;
//			}
			for(int j=x-1;j<N*M;j+=M) {
				if(j%N==y-1) {
					ans=j+1;
					break;
				}
			}
			bw.write(Integer.toString(ans)+"\n");
		}
		bw.flush();
	}
	private static int gcd(int n1,int n2) { //최대 공약수
		if(n2==0) {
			return n1;
		}
		return gcd(n2,n1%n2);
	}
}
