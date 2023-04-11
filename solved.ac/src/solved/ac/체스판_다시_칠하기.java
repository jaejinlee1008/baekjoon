package solved.ac;

import java.util.Scanner;

public class 체스판_다시_칠하기 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int row = scan.nextInt();
		int col = scan.nextInt();
		String del = scan.nextLine();
		int min = Integer.MAX_VALUE;
		String[] board = new String[row];
		for(int i=0;i<row;i++) {
			board[i] = scan.nextLine();
		}
		for(int i=0;i<=row-8;i++) {
			for(int j=0;j<=col-8;j++) {
				min = Math.min(min, Math.min(startWithW(board,i,j), startWithB(board,i,j)));
			}
		}
		System.out.println(min);
	}
	
	public static int startWithW(String[] board, int startRow, int startCol) {
		int count=0;
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				if(i%2==0) {
					if(j%2==0&&board[i+startRow].charAt(j+startCol)!='W') {
						count++;
					}else if(j%2==1&&board[i+startRow].charAt(j+startCol)!='B') {
						count++;
					}
				}else {
					if(j%2==0&&board[i+startRow].charAt(j+startCol)!='B') {
						count++;
					}else if(j%2==1&&board[i+startRow].charAt(j+startCol)!='W') {
						count++;
					}
				}
			}
		}
		return count;
	}
	
	public static int startWithB(String[] board, int startRow, int startCol) {
		int count=0;
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				if(i%2==0) {
					if(j%2==0&&board[i+startRow].charAt(j+startCol)!='B') {
						count++;
					}else if(j%2==1&&board[i+startRow].charAt(j+startCol)!='W') {
						count++;
					}
				}else {
					if(j%2==0&&board[i+startRow].charAt(j+startCol)!='W') {
						count++;
					}else if(j%2==1&&board[i+startRow].charAt(j+startCol)!='B') {
						count++;
					}
				}
			}
		}
		return count;
	}
}
