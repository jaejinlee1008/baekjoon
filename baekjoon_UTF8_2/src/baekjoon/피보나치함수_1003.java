package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class 피보나치함수_1003 {
	public static List<Integer> list0;
	public static List<Integer> list1;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			list0 = new ArrayList<>();
			list1 = new ArrayList<>();
			int n = Integer.parseInt(br.readLine());
			DP(n);
			bw.write(list0.get(n)+" "+list1.get(n)+"\n");
		}
		bw.flush();
	}
	public static void DP(int n) {
		list0.add(1);
		list0.add(0);
		list1.add(0);
		list1.add(1);
		int idx=2;
		if(n>=2) {
			while(idx<=n) {
				list0.add(idx,list0.get(idx-1)+list0.get(idx-2));
				list1.add(idx,list1.get(idx-1)+list1.get(idx-2));
				idx++;
			}
		}
	}
}
