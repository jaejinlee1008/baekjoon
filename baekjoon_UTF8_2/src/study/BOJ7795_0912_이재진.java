package study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ7795_0912_이재진 {
	static int N,M;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			int cnt=0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			int[] arr1 = new int[N+1];
			int[] arr2 = new int[M+1];
			st = new StringTokenizer(br.readLine());
			for(int i=1;i<=N;i++) {
				arr1[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i=1;i<=M;i++) {
				arr2[i] = Integer.parseInt(st.nextToken());
			}
			int a = N;
			int b = M;
			Arrays.sort(arr1);
			Arrays.sort(arr2);
			while(true) {
				if(a==0||b==0) {
					break;
				}
				if(arr1[a]>arr2[b]&&a>0) {
					cnt+=b;
					a--;
				}else {
					if(b>0) {
						b--;
					}
				}
			}
			bw.write(cnt+"\n");
		}
		bw.flush();
	}
}
