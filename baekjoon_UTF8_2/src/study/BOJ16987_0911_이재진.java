package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ16987_0911_이재진 {
	static int N;
	static int[][] input;
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		input = new int[N][2];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			input[i][0] = Integer.parseInt(st.nextToken());
			input[i][1] = Integer.parseInt(st.nextToken());
		}
		if(N==1) {
			System.out.println(0);
			return;
		}
		dfs(0,new boolean[N],0);
		System.out.println(max);
	}
	private static void dfs(int cur,boolean[] broke,int cnt) {
		
//		System.out.println(cur+","+cnt);
//		for(int[] ar : input) {
//			System.out.println(Arrays.toString(ar));
//		}
		boolean flag = false;
		if(cur==N) {
			max = Math.max(max, cnt);
			return;
		}
		if(broke[cur]) {
			dfs(cur+1,broke,cnt);
			return;
		}
		for(int i=0;i<N;i++) {
			if(i==cur||broke[i]) continue;
			flag = true;
			int count=0;
			input[i][0]-=input[cur][1];
			input[cur][0]-=input[i][1];
//			System.out.println(i+"내구도 : " + input[i][0]+", "+cur+"내구도 : " + input[cur][0]);
			if(input[i][0]<=0) {
				broke[i]=true;
				count++;
//				System.out.println(cnt+"증가");
			}
			if(input[cur][0]<=0) {
				broke[cur]=true;
				count++;
//				System.out.println(cnt+"증가");
			}
//			System.out.println((cur+1)+","+(cnt+count)+"넘겨");
			dfs(cur+1,broke,cnt+count);
			if(input[i][0]<=0) {
				broke[i]=false;
			}
			if(input[cur][0]<=0) {
				broke[cur]=false;
			}
			input[i][0]+=input[cur][1];
			input[cur][0]+=input[i][1];
		}
		if(!flag) {
			max = Math.max(max, cnt);
			return;
		}
	}
}
