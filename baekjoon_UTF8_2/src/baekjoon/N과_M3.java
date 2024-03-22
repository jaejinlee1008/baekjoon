package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과_M3 {
	static int N,M;
	static int[] result;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		result = new int[M];
		perm(0);
		bw.flush();
	}
	public static void perm(int cnt) throws IOException {
		if(cnt==M) {
			String tmp = Arrays.toString(result).replace(",", "");
			bw.write(tmp.substring(1,tmp.length()-1)+"\n");
			
			return;
		}
		for(int i=1;i<=N;i++) {
			result[cnt]=i;
			perm(cnt+1);
		}
	}
}
