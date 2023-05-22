package class2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public abstract class 스택_수열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i]=sc.nextInt();
		}
		List<Character> list = new ArrayList<>();
		Stack<Integer> stack = new Stack<>();
		int idx=0;
		int i=1;
		while(i<=N) {
			stack.push(i);
			list.add('+');
			while(!stack.isEmpty()&&stack.peek()==arr[idx]) {
//				System.out.println(stack.peek()+", " + arr[idx]);
				stack.pop();
				idx++;
				list.add('-');
			}
			i++;
		}
		if(stack.isEmpty()) {
			for(char c : list) {
				System.out.println(c);
			}
		}else {
			System.out.println("NO");
		}
		
	}
}
