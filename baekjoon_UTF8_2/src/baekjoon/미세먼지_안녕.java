package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 미세먼지_안녕 {
	static int R,C,T;
	static int[][] room;
	static int uprow, downrow;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		room = new int[R][C];
		for(int i=0;i<R;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<C;j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
				if(room[i][j]==-1) downrow = i;
			}
		}
		uprow = downrow-1;
		for(int i=0;i<T;i++) {
			spread(getPosition());
			upclean();
			downclean();
		}
		int sum=0;
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(room[i][j]>=1) sum+=room[i][j];
			}
		}
		System.out.println(sum);
	}
	
	private static List<int[]> getPosition() {
		List<int[]> list = new ArrayList<>();
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(room[i][j]>=5) list.add(new int[] {i,j,room[i][j]});
			}
		}
		return list;
	}
	
	private static void spread(List<int[]> list) {
		for(int[] pos : list) {
			int cnt=0;
			for(int i=0;i<4;i++) {
				int nx = pos[0]+dx[i];
				int ny = pos[1]+dy[i];
				if(nx>=0&&nx<R&&ny>=0&&ny<C&&room[nx][ny]!=-1) {
					room[nx][ny]+=pos[2]/5;
					cnt++;
				}
			}
			room[pos[0]][pos[1]]-=(pos[2]/5)*cnt;
		}
	}
	
	private static void upclean() {
		
		for(int i=uprow-1;i>0;i--) {
			room[i][0]=room[i-1][0];
		}
		for(int i=0;i<C-1;i++) {
			room[0][i]=room[0][i+1];
		}
		for(int i=0;i<uprow;i++) {
			room[i][C-1] = room[i+1][C-1];
		}
		for(int i=C-1;i>1;i--) {
			room[uprow][i] = room[uprow][i-1];
		}
		room[uprow][1]=0;
		
	}
	
	private static void downclean() {
		
		for(int i=downrow+1;i<R-1;i++) {
			room[i][0]=room[i+1][0];
		}
		for(int i=0;i<C-1;i++) {
			room[R-1][i]=room[R-1][i+1];
		}
		for(int i=R-1;i>downrow;i--) {
			room[i][C-1] = room[i-1][C-1];
		}
		for(int i=C-1;i>1;i--) {
			room[downrow][i] = room[downrow][i-1];
		}
		room[downrow][1]=0;
	}
}
