package baekjoon;

import java.util.Scanner;

public class 피보나치_수3 {
	
	static long MOD = 1000000;
	static long[][] matrix = {{1,1},{1,0}};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextLong();
		
		long[][] A = {{1,1},{1,0}};
		
		System.out.println(pow(A,N-1)[0][0]);
	}
	private static long[][] pow(long[][] A,long n){
		if(n<=1) {
			return A;
		}
		
		long[][] tmp = pow(A,n/2);
		
		tmp = mul(tmp,tmp);
		if(n%2!=0) {
			tmp =  mul(tmp,matrix);
		}
		return tmp;
	}
	private static long[][] mul(long[][] o1, long[][] o2) {
		
		long[][] tmp = new long[2][2];
		tmp[0][0] = ((o1[0][0]*o2[0][0])+(o1[0][1]*o2[1][0]))%MOD;
		tmp[0][1] = ((o1[0][0]*o2[0][1])+(o1[0][1]*o2[1][1]))%MOD;
		tmp[1][0] = ((o1[1][0]*o2[0][0])+(o1[1][1]*o2[1][0]))%MOD;
		tmp[1][1] = ((o1[1][0]*o2[0][1])+(o1[1][1]*o2[1][1]))%MOD;
		return tmp;
	}
	
	
	
	
	
}
