package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* summary : 재료의 신맛과 쓴맛이 주어진다
 * 			  고른 재료의 신맛은 곱하고 쓴맛은 더한다
 * 			  신맛과 쓴맛의 차이가 제일 적은 조합을 선택하여 그 둘의 차를 출력한다
 * strategy : 부분 집합 이용
 * 
 * note : 절대값 이용
 */
public class 도영이가_만든_맛있는_음식 {
	static int N;
	static int min=Integer.MAX_VALUE;
	static boolean[] visited;
	static int[][] taste;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		visited = new boolean[N];
		taste = new int[N][2];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			taste[i][0]=Integer.parseInt(st.nextToken());
			taste[i][1]=Integer.parseInt(st.nextToken());
		}
		subset(0,0);
		System.out.println(min);
	}
	
	private static void subset(int idx,int count) {
		if(count>0&&idx==N) {
			int sour=1;
			int bitter=0;
			for(int i=0;i<N;i++) {
				if(visited[i]) {
					sour*=taste[i][0];
					bitter+=taste[i][1];
				}
			}
			min = Math.min(Math.abs(sour-bitter), min);
			return;
		}else if(idx==N) {
			return;
		}
		visited[idx]=true;
		subset(idx+1,count+1);
		visited[idx]=false;
		subset(idx+1,count);
	}
}
