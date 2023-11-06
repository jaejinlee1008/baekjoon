package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연산자_끼워넣기 {
	static int N;
	static int[] input;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		input = new int[N];
		for(int i=0;i<N;i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int[] oper = new int[4];
		for(int i=0;i<4;i++) {
			oper[i] = Integer.parseInt(st.nextToken());
		}
		dfs(1,input[0],oper);
		System.out.println(max);
		System.out.println(min);
	}
	private static void dfs(int cnt,int result,int[] oper) {
		if(cnt==N) {
			max = Integer.max(result, max);
			min = Integer.min(result, min);
			return;
		}
		
		if(oper[0]>0) {
			oper[0]--;
			dfs(cnt+1,result+input[cnt],oper);
			oper[0]++;
		}
		if(oper[1]>0) {
			oper[1]--;
			dfs(cnt+1,result-input[cnt],oper);
			oper[1]++;
		}
		if(oper[2]>0) {
			oper[2]--;
			dfs(cnt+1,result*input[cnt],oper);
			oper[2]++;
		}
		if(oper[3]>0) {
			oper[3]--;
			dfs(cnt+1,result/input[cnt],oper);
			oper[3]++;
		}
		
	}
}
