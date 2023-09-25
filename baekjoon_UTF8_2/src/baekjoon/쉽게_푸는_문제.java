package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 쉽게_푸는_문제 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int[] arr = new int[1001];
		List<Integer> list = new ArrayList<>();
		list.add(0);
		int cnt=0;
		int idx=1;
		while(cnt<=1000) {
			for(int i=0;i<idx;i++) {
				list.add(idx);
				cnt++;
			}
			idx++;
		}
		for(int i=1;i<=1000;i++) {
			arr[i] = arr[i-1]+list.get(i);
		}
		System.out.println(arr[B]-arr[A-1]);
	}
}
