package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 행렬_제곱 {
	static int N;
	static long B;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		B = Long.parseLong(st.nextToken());
		int[][] matrix = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken())%1000;
			}
		}
		int[][] answer = pow(matrix,B);
		
		for(int[] ar : answer) {
			for(int i : ar) {
				bw.write(i+" ");
			}
			bw.newLine();
		}
		bw.flush();
	}
	private static int[][] mul(int[][] a, int[][] b){
		int[][] result = new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				for(int k=0;k<N;k++) {
					result[i][j] += (a[i][k]*b[k][j]);
					result[i][j]%=1000;
				}
				
			}
		}
		return result;
	}
	
	private static int[][] pow(int[][] mat, long n){
		if(n==1L) {
			return mat;
		}
		int[][] tmp = pow(mat,n/2);
		if(n%2==0) {
			return mul(tmp,tmp);
		}else {
			return mul(mul(tmp,tmp),mat);
		}
	}
}
