package study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ11501_0821_이재진 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N+1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			long result = 0;
			for(int j=1;j<=N;j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			int max = arr[N];
			for(int j=N-1;j>0;j--) {
				if(max>arr[j]) {
					result+=max-arr[j];
				}else {
					max = arr[j];
				}
			}
			bw.write(result+"\n");
		}
		bw.flush();
	}
}
