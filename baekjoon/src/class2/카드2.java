package class2;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class 카드2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Deque<Integer> dq = new LinkedList<>();
		for(int i=1;i<=N;i++) {
			dq.add(i);
		}
		if(N==1) {
			System.out.println("1");
		}else {
			while(true) {
				dq.pollFirst();
				if(dq.size()==1) {
					break;
				}else {
					dq.add(dq.pollFirst());
				}
				
			}
			System.out.println(dq.peek());
		}
		
	}
}
