package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ14889_0817_이재진 {
	static int N;
	static int[][] team;
	static int R;
	static int min = Integer.MAX_VALUE;
	static int sum1;
	static int sum2;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		R = N/2;
		team = new int[N][N];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				team[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		comb(0,0,new int[R],new boolean[N]);
		System.out.println(min);
	}
	private static void comb(int cnt,int start,int[] output,boolean[] visited) {
		if(cnt==R) {
			int team1=0;
			int team2=0;
			int[] other = new int[R];
			int idx=0;
			for(int i=0;i<N;i++) {
				if(!visited[i]) {
					other[idx++] = i; 
				}
			}
			for(int i=0;i<R;i++) {
				for(int j=i+1;j<R;j++) {
					team1+=team[output[i]][output[j]]+team[output[j]][output[i]];
					team2+=team[other[i]][other[j]]+team[other[j]][other[i]];
				}
			}
			
			min = Math.min(min, Math.abs(team1-team2));
			return;
		}
		for(int i=start;i<N;i++) {
			if(!visited[i]) {
				visited[i]=true;
				output[cnt] = i;
				comb(cnt+1,i+1,output,visited);
				visited[i]=false;
			}
			
		}
	}
}
