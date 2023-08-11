package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class 가장_가까운_세_사람의_심리적_거리 {
	static int R=3;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			int N = Integer.parseInt(br.readLine());
			String[] arr = br.readLine().split(" ");
			int[] p = new int[N];
			int cnt=0;
			while(++cnt<=R) p[N-cnt]=1;
			
			int min = Integer.MAX_VALUE;
			do {
				String[] picked = new String[R];
				int idx=0;
				for(int j=0;j<N;j++) {
					if(p[j]!=0) {
						picked[idx++] = arr[j];
					}
				}
				int sum1=0;
				int sum2=0;
				int sum3=0;
				for(int j=0;j<4;j++) {
					if(picked[0].charAt(j)!=picked[1].charAt(j)) sum1++;
					if(picked[0].charAt(j)!=picked[2].charAt(j)) sum2++;
					if(picked[1].charAt(j)!=picked[2].charAt(j)) sum3++;
				}
//				System.out.println(sum1+","+sum2+","+sum3);
				min = Math.min(min, (sum1+sum2+sum3));
				if(min==0) break;
			}while(np(p));
			bw.write(Integer.toString(min)+"\n");
		}
		bw.flush();
	}
	private static boolean np(int[] p) {
		int N = p.length;
		int i=N-1;
		
		
		while(i>0&&p[i-1]>=p[i]) --i;
		
		if(i==0) return false;
		
		int j=N-1;
		while(p[i-1]>=p[j]) j--;
		swap(p,i-1,j);
		
		int k=N-1;
		while(i<k) {
			swap(p,i++,k--);
		}
		return true;
	}
	
	private static void swap(int[] p,int i,int j) {
		int tmp = p[i];
		p[i] = p[j];
		p[j] = tmp;
	}
}
