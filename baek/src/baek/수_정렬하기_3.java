package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 수_정렬하기_3 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		long N = Long.parseLong(br.readLine());
//		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int[] arr = new int[(int)N];
		for(long i=0;i<N;i++) {
			arr[(int)i]=(Integer.parseInt(br.readLine()));
		}
		Arrays.sort(arr);
		for(int i : arr) {
			sb.append(i+"\n");
			
		}
		System.out.println(sb.toString());
	}
}
