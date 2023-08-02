package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 구간_합_구하기_5 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				if(j==0) {
					arr[i][j]=Integer.parseInt(st.nextToken());
				}else {
					arr[i][j] = arr[i][j-1]+Integer.parseInt(st.nextToken());
				}
				
			}
		}
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int sum=0;
			for(int j=x1-1;j<=y1-1;j++) {
				if(x2>1) {
					sum += arr[j][y2-1]-arr[j][x2-2];
				}else {
					sum += arr[j][y2-1]; 
				}
				
			}
			bw.write(Integer.toString(sum));
			bw.newLine();
		}
		bw.flush();
	}
}
