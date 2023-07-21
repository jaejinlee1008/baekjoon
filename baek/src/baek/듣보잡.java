package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class µË∫∏¿‚ {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Set<String> set1 = new HashSet<>();
		List<String> list = new ArrayList<>();
		int count=0;
		for(int i=0;i<N;i++) {
			set1.add(br.readLine());
		}
		for(int i=0;i<M;i++) {
			String str = br.readLine();
			if(set1.contains(str)) {
				count++;
				list.add(str);
			}
		}
		list.sort((o1,o2)->o1.compareTo(o2));
		sb.append(count+"\n");
		for(String s : list) {
			sb.append(s+"\n");
		}
		System.out.println(sb);
	}
}
