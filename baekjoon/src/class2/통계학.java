package class2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class 통계학 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Map<Integer,Integer> map = new HashMap<>();
		List<Integer> list = new ArrayList<>();
		double sum=0;
		int max=Integer.MIN_VALUE;
		for(int i=0;i<N;i++) {
			int tmp = sc.nextInt();
			map.put(tmp, map.getOrDefault(tmp, 0)+1);
			max = Math.max(max, map.get(tmp));
			list.add(tmp);
			sum+=tmp;
		}
		List<Integer> list2 = new ArrayList<>();
		for(int key : map.keySet()) {
			if(map.get(key)==max) {
				list2.add(key);
			}
		}
		
		System.out.println((int)Math.rint((sum/N)));
		Collections.sort(list);
		Collections.sort(list2);
		System.out.println(list.get(list.size()/2));
		if(list2.size()<2) {
			System.out.println(list2.get(0));
		}else {
			System.out.println(list2.get(1));
		}
		System.out.println(list.get(list.size()-1)-list.get(0));
		
	}
}
