package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 마인크래프트 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N=0;
		int M=0;
		int B = 0;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				min = Math.min(min, arr[i][j]);
				max = Math.max(max, arr[i][j]);
			}
		}
		int mintime = Integer.MAX_VALUE;
		int maxheight = Integer.MIN_VALUE;
		for(int i=min;i<=max;i++) {
			int time=0;
			int block=B;
			for(int j=0;j<N;j++) {
				for(int k=0;k<M;k++) {
					int dif = arr[j][k]-i;
					if(dif>0) {
						time+=Math.abs(dif)*2;
						block+=Math.abs(dif);
					}else if(dif<0) {
						time+=Math.abs(dif);
						block-=Math.abs(dif);
					}
				}
			}
			if(block<0) {
				break;
			}
			if(time<=mintime) {
				mintime = time;
				maxheight = i;
			}
		}
		
		System.out.println(mintime + " " + maxheight);
	}
}
