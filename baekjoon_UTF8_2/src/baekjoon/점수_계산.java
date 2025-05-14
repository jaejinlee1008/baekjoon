package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 점수_계산 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		List<Integer> list = new ArrayList<>();
		Map<Integer,Integer> map = new HashMap<>();
		for(int i=1;i<=8;i++) {
			int n = Integer.parseInt(br.readLine());
			list.add(n);
			map.put(n, i);
		}
		Collections.sort(list,Collections.reverseOrder());
		int sum=0;
		for(int i=0;i<5;i++) {
			sum+=list.get(i);
		}
		bw.write(Integer.toString(sum));
		bw.newLine();
		List<Integer> list2 = new ArrayList<>();
		for(int i=0;i<5;i++) {
			list2.add(map.get(list.get(i)));
		}
		Collections.sort(list2);
		for(int i=0;i<5;i++) {
			bw.write(list2.get(i)+" ");
		}
		bw.flush();
	}
}
