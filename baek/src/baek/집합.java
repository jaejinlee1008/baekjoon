package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class С§Че {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int M = Integer.parseInt(br.readLine());
		Set<Integer> set = new HashSet<>();
		for(int i=0;i<M;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String calc = st.nextToken();
			
			if(calc.equals("add")) {
				int num = Integer.parseInt(st.nextToken());
				set.add(num);
			}else if(calc.equals("remove")) {
				int num = Integer.parseInt(st.nextToken());
				if(set.contains(num)) {
					set.remove(num);
				}
			}else if(calc.equals("check")) {
				int num = Integer.parseInt(st.nextToken());
				if(set.contains(num)) {
					sb.append("1\n");
				}else {
					sb.append("0\n");
				}
			}else if(calc.equals("toggle")) {
				int num = Integer.parseInt(st.nextToken());
				if(set.contains(num)) {
					set.remove(num);
				}else {
					set.add(num);
				}
			}else if(calc.equals("all")) {
				for(int j=1;j<=20;j++) {
					set.add(j);
				}
			}else if(calc.equals("empty")) {
				set.clear();
			}
		}
		System.out.println(sb);
	}
}
