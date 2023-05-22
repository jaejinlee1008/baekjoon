package class2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class 단어_정렬 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Set<String> set = new HashSet<>();
		for(int i=0;i<N;i++) {
			set.add(sc.next());
		}
		List<String> list = new ArrayList<>(set);
		list.sort(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if(o1.length()<o2.length()) {
					return -1;
				}else if(o1.length()>o2.length()) {
					return 1;
				}else {
					return o1.compareTo(o2);
				}
			}
			
		});
		for(String s : list) {
			System.out.println(s);
		}
	}
}
