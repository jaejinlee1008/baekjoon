package study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ6593_0818_이재진 {
	static int L,R,C;
	static char[][][] map;
	static boolean[][][] visited;
	static int[] start;
	static int[] end;
	static int[] dl = {0,0,0,0,-1,1};
	static int[] dr = {-1,1,0,0,0,0};
	static int[] dc = {0,0,-1,1,0,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			if(L==0&&R==0&&C==0) {
				break;
			}
			map = new char[L][R][C];
			visited = new boolean[L][R][C];
			start = new int[3]; //시작 층,행, 열 저장
			end = new int[3]; //끝 층,행, 열 저장
			for(int i=0;i<L;i++) { //층
				for(int j=0;j<R;j++) { //행
					String str = br.readLine();
					for(int k=0;k<C;k++) { //열
						map[i][j][k]=str.charAt(k);
						if(str.charAt(k)=='#') visited[i][j][k]=true;
						else if(str.charAt(k)=='S') {
							start[0]=i;
							start[1]=j;
							start[2]=k;
						}else if(str.charAt(k)=='E') {
							end[0]=i;
							end[1]=j;
							end[2]=k;
						}
					}
				}
				String tmp = br.readLine();
			}
			int result = BFS(start[0],start[1],start[2]);
			if(visited[end[0]][end[1]][end[2]]) {
				bw.write("Escaped in "+result+" minute(s).\n");
			}else {
				bw.write("Trapped!\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
		
	}
	private static int BFS(int l, int r, int c) {
		Queue<int[]> queue = new LinkedList<>();
		int num=0;
		queue.add(new int[] {l,r,c,0});
		visited[l][r][c]=true;
		while(!queue.isEmpty()) {
			int[] tmp = queue.poll();
			if(map[tmp[0]][tmp[1]][tmp[2]]=='E') {
				num=tmp[3];
				break;
			}
			for(int i=0;i<6;i++) {
				int nl = tmp[0]+dl[i];
				int nr = tmp[1]+dr[i];
				int nc = tmp[2]+dc[i];
				if(nl>=0&&nl<L&&nr>=0&&nr<R&&nc>=0&&nc<C&&!visited[nl][nr][nc]) {
					visited[nl][nr][nc]=true;
					queue.add(new int[] {nl,nr,nc,tmp[3]+1});
					
				}
			}
		}
		return num;
	}
}
