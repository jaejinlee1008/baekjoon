package baekjoon;

import java.util.Scanner;

public class N_Queen {
	static int N;
	static int[] col;
	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		col = new int[N];
		setQueen(0);
		System.out.println(ans);
	}
	private static void setQueen(int row) {
		if(row==N) {
			ans++;
			return;
		}
		for(int i=0;i<N;i++) { //열에 담는다
			col[row]=i;
			if(isAvailable(row)) {
				setQueen(row+1);
			}
		}
	}
	private static boolean isAvailable(int row) {
		
		for(int i=0;i<row;i++) {
			if(col[i]==col[row]||row-i==Math.abs(col[row]-col[i])) {
				return false;
			}
		}
		
		return true;
	}
}
