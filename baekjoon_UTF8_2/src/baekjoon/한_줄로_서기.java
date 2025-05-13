package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 한_줄로_서기 {
	public static int N;
	public static int[] arr;
	public static int[] numbers;
	public static int[] compare;
	public static boolean[] isSelected;
	public static BufferedWriter bw;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		isSelected = new boolean[N+1];
		numbers = new int[N];
		compare = new int[N+1];
		perm(0);
		bw.flush();
	}
	
	public static void perm(int cnt) throws IOException {
		if(cnt==N) {
			compare[numbers[0]] = 0;
			for(int i=1;i<N;i++) {
				int count=0;
				for(int j=0;j<i;j++) {
					if(numbers[j]>numbers[i]) {
						count++;
					}
				}
				compare[numbers[i]] = count;
			}
			for(int i=0;i<N;i++) {
				if(arr[i]!=compare[i+1]) {
					return;
				}
			}
			for(int i=0;i<N;i++) {
				bw.write(numbers[i]+" ");
			}
			return;
		}
		for(int i=1;i<=N;i++) {
			if(isSelected[i]) continue;
			numbers[cnt] = i;
			isSelected[i] = true;
			perm(cnt+1);
			isSelected[i] = false;
		}
	}
}
