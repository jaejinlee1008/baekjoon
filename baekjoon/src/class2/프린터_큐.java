package class2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class 프린터_큐 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt();
		for(int i=0;i<test_case;i++) {
			int N = sc.nextInt();
			int target = sc.nextInt();
			Queue<Integer> q = new LinkedList<>();
			Map<Integer,Integer> map = new HashMap<>();
			List<Integer> list = new ArrayList<>();
			for(int j=0;j<N;j++) {
				int tmp = sc.nextInt();
				list.add(tmp);
				map.put(j,tmp);
				q.add(j);
			}
			Collections.sort(list);
			Stack<Integer> stack = new Stack<>();
			for(int num : list) {
				stack.add(num);
			}
			int count=0;
			while(!q.isEmpty()) {
				if(stack.peek()==map.get(q.peek())) {
					count++;
					if(q.peek()==target) {
						break;
					}else {
						q.poll();
						stack.pop();
					}
				}else {
					q.add(q.poll());
				}
			}
			System.out.println(count);
		}
	}
}
