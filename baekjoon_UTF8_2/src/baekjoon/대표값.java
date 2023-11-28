package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class 대표값 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sum =0;
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0;i<10;i++) {
			int input = Integer.parseInt(br.readLine());
			sum+=input;
			map.put(input, map.getOrDefault(input, 0)+1);
		}
		int max = 0;
		int maxnum=0;
		for(int key : map.keySet()) {
			if(map.get(key)>max) {
				max = map.get(key);
				maxnum = key;
			}
		}
		System.out.println(sum/10);
		System.out.println(maxnum);
	}
}
