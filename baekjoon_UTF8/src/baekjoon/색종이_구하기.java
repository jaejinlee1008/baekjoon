package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 색종이_구하기 {
	static int[] color = new int[2]; //0-white, 1-blue
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {0,0,N});
		while(!queue.isEmpty()) {
			int[] tmp = queue.poll();
			int x1=tmp[0];
			int y1=tmp[1];
			int n=tmp[2];
			int x2 = x1+n;
			int y2 = y1+n;
			
			int num = arr[x1][y1];
			
			if(n==2) {
				int[] colortmp =new int[2];
				for(int i=x1;i<x2;i++) {
					for(int j=y1;j<y2;j++) {
						colortmp[arr[i][j]]++;
					}
				}
				for(int i=0;i<2;i++) {
					if(colortmp[i]==4) {
						color[i]++;
					}else {
						color[i]+=colortmp[i];
					}
				}
			}else {
				boolean stop=false;
				for(int i=x1;i<x2;i++) {
					for(int j=y1;j<y2;j++) {
						if(num!=arr[i][j]) {
							queue.add(new int[] {x1,y1,n/2});
							queue.add(new int[] {x1,y1+n/2,n/2});
							queue.add(new int[] {x1+n/2,y1,n/2});
							queue.add(new int[] {x1+n/2,y1+n/2,n/2});
							stop=true;
							break;
						}
					}
					if(stop) break;
				}
				if(!stop) {
					color[arr[x1][y1]]++;
				}
			}
			
		}
		System.out.println(color[0]);
		System.out.println(color[1]);
	}
}
