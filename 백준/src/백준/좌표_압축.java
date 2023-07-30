package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class 좌표_압축 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Map<Integer,Integer> map = new TreeMap<>();
		int[] arr = new int[N];
		for(int i=0;i<N;i++) {
			int n = Integer.parseInt(st.nextToken());
			map.put(n, 0);
			arr[i]=n;
		}
		int idx=0;
		for(int i : map.keySet()) {
			map.put(i, idx++);
		}
		for(int i : arr) {
			bw.write(Integer.toString(map.get(i))+" ");
		}
		bw.flush();
	}
}
