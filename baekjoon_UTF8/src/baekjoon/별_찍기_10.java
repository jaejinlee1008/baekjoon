package baekjoon;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class 별_찍기_10 {
	static int N;
	static char[][] map;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = sc.nextInt();
		map = new char[N][N];
		
		
		recursive(0,0,N,false);
		
		for(int i=0;i<N;i++) {
			bw.write(map[i]);
			bw.newLine();
		}
		bw.flush();
		bw.close();
		
	}
	private static void recursive(int x, int y,int num,boolean blank) {
		
		if(blank) {
			for(int i=x;i<x+num;i++) {
				for(int j=y;j<y+num;j++) {
					map[i][j]=' ';
				}
			}
			return;
		}
		if(num==1) {
			map[x][y]='*';
			return;
		}
		
		int size = num/3;
		int cnt=0;
		for(int i=x;i<x+num;i+=size) {
			for(int j=y;j<y+num;j+=size) {
				cnt++;
				if(cnt==5) {
					recursive(i,j,size,true);
				}else {
					recursive(i,j,size,false);
				}
			}
		}
		
	}
}
