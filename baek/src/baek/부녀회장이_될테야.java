package baek;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 부녀회장이_될테야 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[k+1][n];
			for(int j=0;j<n;j++) {
				arr[0][j] = j+1;
			}
			dp(arr,k,n);
			bw.write(Integer.toString(arr[k][n-1]));
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();
	}
	public static void dp(int[][] arr,int k,int n) {
		
		for(int i=1;i<=k;i++) {
			for(int j=0;j<n;j++) {
				if(j==0) {
					arr[i][j]=1;
				}else {
					arr[i][j] = arr[i][j-1]+arr[i-1][j];
				}
				
			}
		}
		
	}
}
