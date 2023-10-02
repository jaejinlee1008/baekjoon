package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 스도쿠 {
	static int[][] sudoku;
	static boolean end;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sudoku = new int[9][9];
		for(int i=0;i<9;i++) {
			String str = br.readLine();
			for(int j=0;j<9;j++) {
				sudoku[i][j] = str.charAt(j)-'0';
				
			}
		}
		
		dfs(0);
		
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				System.out.print(sudoku[i][j]);
			}
			System.out.println();
		}
		
	}
	private static void dfs(int cnt) {
		if(cnt==81) {
			end=true;
			return;
		}
		int row = cnt/9;
		int col = cnt%9;
		if(sudoku[row][col]!=0) {
			dfs(cnt+1);
		}else {
			for(int i=1;i<=9;i++) {
				if(isValid(row,col,i)) {
					sudoku[row][col]=i;
					dfs(cnt+1);
					if(end) return;
					sudoku[row][col]=0;
				}
			}
		}
	}
	private static boolean isValid(int row, int col, int n) {
		
		for(int i=0;i<9;i++) {
			if(sudoku[row][i]==n||sudoku[i][col]==n) return false;
		}
		
		int smallrow = (row/3)*3;
		int smallcol = (col/3)*3;
		for(int i=smallrow;i<smallrow+3;i++) {
			for(int j=smallcol;j<smallcol+3;j++) {
				if(sudoku[i][j]==n) return false;
			}
		}
		
		return true;
	}
}
