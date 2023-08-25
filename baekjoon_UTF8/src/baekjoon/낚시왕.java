package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class 낚시왕 {
	static class Shark{
		int num,row,col,speed,dir,size;

		public Shark(int num, int row, int col, int speed, int dir, int size) {
			super();
			this.num = num;
			this.row = row;
			this.col = col;
			this.speed = speed;
			this.dir = dir;
			this.size = size;
		}

		
		
	}
	static int R,C,M;
	static Shark[] sharkList;
	static List<int[]> delList;
	static int[][] map;
	static int[] dx = {0,-1,1,0,0};
	static int[] dy = {0,0,0,1,-1};
	public static void main(String[] args) throws IOException,NullPointerException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[R+1][C+1];
		sharkList = new Shark[M+1];
		for(int i=1;i<=M;i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			sharkList[i]=(new Shark(i,r,c,s,d,z));
			map[r][c]=i;
		}
		int cur=0;
		long sum=0;
		while(++cur<=C) {
			delList = new ArrayList<>();
			for(int i=1;i<=R;i++) {
				if(map[i][cur]!=0) {
					sum+=sharkList[map[i][cur]].size;
					sharkList[map[i][cur]]=null;
					map[i][cur]=0;
					break;
				}
			}
			for(int i=1;i<=M;i++) { //상어 이동 단계
				if(sharkList[i]!=null) {
					int curx = sharkList[i].row;
					int cury = sharkList[i].col;
					move(sharkList[i],i);
					map[curx][cury]=0;
				}
			}
			
			for(int i=1;i<=M;i++) { //맵에 상어 배치 단계
				if(sharkList[i]!=null) {
					int curx = sharkList[i].row;
					int cury = sharkList[i].col;
					if(map[curx][cury]==0) {
						map[curx][cury]=sharkList[i].num;
					}else {
						if(sharkList[map[curx][cury]].size>sharkList[i].size) {
							sharkList[i]=null;
						}else {
							sharkList[map[curx][cury]]=null;
							map[curx][cury]=sharkList[i].num;
						}
					}
				}
			}
		}
		System.out.println(sum);
	}
	private static void move(Shark s,int num) {
		for(int i=0;i<s.speed;i++) {
			int nx = s.row+dx[s.dir];
			int ny = s.col+dy[s.dir];
			
			if(nx>0&&nx<=R&&ny>0&&ny<=C) {
				s.row=nx;
				s.col=ny;
			}else {
				if(s.dir==1) {
					s.dir=2;
				}else if(s.dir==2) {
					s.dir=1;
				}else if(s.dir==3) {
					s.dir=4;
				}else {
					s.dir=3;
				}
				i--;
			}
		}
		
	}
}
