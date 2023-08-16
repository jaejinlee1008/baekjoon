package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class 월드컵 {
	//15개 경기에서 매치하는 팀 정보
	static  int[] team1 = {0,0,0,0,0,1,1,1,1,2,2,2,3,3,4};
	static  int[] team2 = {1,2,3,4,5,2,3,4,5,3,4,5,4,5,5};
	
	static int[] win,draw,lose;
	static boolean flag;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i=0;i<4;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			win = new int[6];
			draw = new int[6];
			lose = new int[6];
			
			int w=0, d=0, l=0; //15경기의 승무패수
			for(int team=0;team<6;team++) {
				w += win[team] = Integer.parseInt(st.nextToken());
				d += draw[team] = Integer.parseInt(st.nextToken());
				l += lose[team] = Integer.parseInt(st.nextToken());
				if(w+d+l!=30) { // 총 15경기 후에 승패수 합이 30이 아니면
					flag=false;
				}else {
					check(0); //경기 횟수
				}
				if(flag) {
					System.out.print("1 ");
				}else {
					System.out.print("0 ");
				}
			}
			
		}
	}
	private static void check(int match) {
		//종료조건 : 모든 경기를 다 한 경우
		if(match==15) {
			flag=true;
			return;
		}
		//반복조건 : 3가지 경우 비교
		int a = team1[match];
		int b = team1[match];
		
		//1. a>b
		if(win[a]>0&&lose[b]>0) {
			win[a]--;
			lose[b]--;
			check(match+1); //다음 경기하러 보냄
			win[a]++;
			lose[b]++;
		}
		
		//2. a<b
		if(lose[a]>0&&win[b]>0) {
			win[b]--;
			lose[a]--;
			check(match+1); //다음 경기하러 보냄
			win[b]++;
			lose[a]++;
		}
		//3. a==b
		if(draw[a]>0&&draw[b]>0) {
			draw[b]--;
			draw[a]--;
			check(match+1); //다음 경기하러 보냄
			draw[b]++;
			draw[a]++;
		}
	}
}
