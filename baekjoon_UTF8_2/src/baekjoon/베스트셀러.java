package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 베스트셀러 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Map<String,Integer> map = new HashMap<>();
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			map.put(str, map.getOrDefault(str, 0)+1);
		}
		List<String> list = new ArrayList<>();
		for(String s : map.keySet()) {
			list.add(s);
		}
		Collections.sort(list,new Comparator<String>() {
			public int compare(String a, String b) {
				if(map.get(a)==map.get(b)) {
					return a.compareTo(b);
				}else {
					return map.get(b).compareTo(map.get(a));
				}
				
			}
		});
		System.out.println(list.get(0));
	}

}
