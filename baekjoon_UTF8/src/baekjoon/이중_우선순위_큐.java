package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 이중_우선순위_큐 {
	static Map<Integer,Integer> map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0;i<T;i++) {
			
			int k = Integer.parseInt(br.readLine());
			PriorityQueue<Integer> maxq = new PriorityQueue<>(Collections.reverseOrder());//최대값
			PriorityQueue<Integer> minq = new PriorityQueue<>();//최소값
			map = new HashMap<>();
			for(int j=0;j<k;j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String str = st.nextToken();
				int n = Integer.parseInt(st.nextToken());
				if(str.equals("D")) {
					if(map.isEmpty()) {
						continue;
					}else if(n==1) {
						delete(maxq);
					}else {
						delete(minq);
					}
					
				}else {
					maxq.add(n);
					minq.add(n);
					map.put(n, map.getOrDefault(n, 0)+1);
				}
			}
			
			if(map.isEmpty()) sb.append("EMPTY\n");
			else {
				
				int num = delete(maxq);
				sb.append(num+" ");
				if(!map.isEmpty()) {
					num=delete(minq);
				}
				sb.append(num+"\n");
			}
			
			
		}
		System.out.println(sb.toString());
//		bw.write(sb.toString());
//		bw.flush();
	}
	static int delete(PriorityQueue<Integer> pq) {
		int num=0;
		while(!pq.isEmpty()) {
			num = pq.poll();
			
			int cnt = map.getOrDefault(num, 0);
			if(cnt==0) continue;
			
			if(cnt==1) map.remove(num);
			else map.put(num, cnt-1);
			break;
		}
		return num;
	}
}
