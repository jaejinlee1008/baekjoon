package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Z {
	public static int count=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		recursion((int)Math.pow(2, N),r,c);
		System.out.println(count);
	}
	public static void recursion(int N,int r, int c) {
		int[][] arr = {{0,1},{2,3}};
		if(N==2) {
			count+=arr[r][c];
			return;
		}
		int div = N/2;
		count+=(r/(div))*Math.pow(div,2)*2;
		count+=(c/(div))*Math.pow(div, 2);
		
		recursion(div,r%div,c%div);
		
	}
}
