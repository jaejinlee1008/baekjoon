package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class 회의실_배정 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		if(N==1) {
			System.out.println("1");
			return;
		}
		List<int[]> list = new ArrayList<>();
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			list.add(new int[] {s,e});
		}
		Collections.sort(list, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1]==o2[1]) {
					return o1[0]-o2[0];
				}else {
					return o1[1]-o2[1];
				}

				
			}

			
		});
//		for(int[] a : list) {
//			System.out.println(Arrays.toString(a));
//		}

		
		int end = 0;
		int count=0;
		
		for(int i=0;i<N;i++) {
			if(end<=list.get(i)[0]) {
				end = list.get(i)[1];
				count++;
			}
		}
		System.out.println(count);
	}
}
