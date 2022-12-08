package baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ChessArray {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<Integer> defaultchess = new ArrayList<>(Arrays.asList(1,1,2,2,2,8));
		ArrayList<Integer> newchess = new ArrayList<>();
		
		for(int i=0;i<defaultchess.size();i++)
		{
			newchess.add(scan.nextInt());
		}
		
		for(int i=0;i<defaultchess.size();i++)
		{
			defaultchess.set(i,(defaultchess.get(i)-newchess.get(i)));
			System.out.print(defaultchess.get(i)+ " ");
		}
		
	}
	
}
