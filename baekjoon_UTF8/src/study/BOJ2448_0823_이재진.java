package study;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ2448_0823_이재진 {
	static char[][] arr;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = sc.nextInt();
		int M = 2*N-1;
		arr = new char[N][M];
		for(int i=N-1;i>=0;i--) {
			for(int j=0;j<M;j++) {
				if(j>=(N-1)-i&&j<=M-(N-i)) {
					arr[i][j] = '*';
				}else {
					arr[i][j] = ' ';
				}
				 
			}
		}
		
		DFS(0,0,N,M);
		for(char[] c : arr) {
			bw.write(c);
			bw.newLine();
		}
		bw.flush();
	}
	private static void DFS(int x1,int y1, int x2,int y2) {
		if((x2-x1)<=0) {
			
			return;
		}
		int row = (x2+x1)/2;
		int rowlen = (x2-x1)/2;
		int len = (y2-y1)/4;
		for(int i=row;i<=row+rowlen;i++) {
			for(int j=y1+len+1;j<(y2-len)-1;j++) {
				if(j>=(y1+len+1)-(row-i)&&j<((y2-len)-1)-(i-row))
				arr[i][j]=' ';
			}
		}
		DFS(x1,y1+len+1,row,y2-len-1);
		DFS(row,y1,row+rowlen,(y1+((y2-y1)/2)));
		DFS(row,y1+((y2-y1)/2)+1,row+rowlen,y2);
	}
}
