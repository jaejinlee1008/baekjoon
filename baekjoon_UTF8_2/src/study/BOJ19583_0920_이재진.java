package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ19583_0920_이재진 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken().replace(":", ""));
		int end1 = Integer.parseInt(st.nextToken().replace(":", ""));
		int end2 = Integer.parseInt(st.nextToken().replace(":", ""));
		String input = "";
		Map<String,Boolean> map1 = new HashMap<>();
		Map<String,Boolean> map2 = new HashMap<>();
		Set<String> names = new HashSet<>();
		while((input = br.readLine()) != null) {
			st = new StringTokenizer(input);
			int time=0;
			String name="";
			while(st.hasMoreTokens()) {
				time = Integer.parseInt(st.nextToken().replace(":", ""));
				name = st.nextToken();
			}
			if(time<=start) {
				map1.put(name, true);
			}else if(time>=end1&&time<=end2) {
				map2.put(name,true);
			}
			names.add(name);
		}
		int cnt=0;
		for(String n : names) {
			if(map1.containsKey(n)&&map2.containsKey(n)) {
				if(map1.get(n)&&map2.get(n)) cnt++;
			}
		}
		System.out.println(cnt);
	}
}
