package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ13414_1018_이재진 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		Map<String,Integer> map = new HashMap<>();
		PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return Integer.compare(map.get(o1), map.get(o2));
			}

			
			
		});
		for(int i=1;i<=L;i++) {
			String str= br.readLine();
			map.put(str, i);
		}
		for(String s : map.keySet()) {
			pq.add(s);
		}
		for(int i=0;i<K;i++) {
			if(!pq.isEmpty()) {
				System.out.println(pq.poll());
			}else {
				break;
			}
			
		}
	}
}
