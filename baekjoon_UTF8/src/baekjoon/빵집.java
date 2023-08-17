package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 빵집 {
	static int R;
	static int C;
	static char[][] map;
	static int[] dx = {-1,0,1};
	static int ans;
	static boolean flag;
	static int[] output;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		output = new int[C];
		for(int i=0;i<R;i++) {
			String tmp = br.readLine();
			map[i] = tmp.toCharArray();
		}
		int j=0;
		while(!DFS(j,j,0,0,new boolean[R][C])) {
			j++;
		}
		
		System.out.println(ans);
	}
	private static boolean DFS(int first,int row,int cnt,int pick,boolean[][] visited) {
		System.out.println(first+","+row+","+cnt+","+pick);
		
		if(cnt==C-1) {
			System.out.println(Arrays.toString(output));
			ans = Math.max(ans, pick+1);
			DFS(first+1,first+1,0,pick+1,visited);
			System.out.println();
			return true;
		}
		if(row>=R) return false;
		if(cnt==0) output[0]=row;
		visited[row][cnt]=true;
		System.out.println(Arrays.toString(output));
		for(int i=0;i<3;i++) {
			int nx = row+dx[i];
			if(nx>=0&&nx<R&&!visited[nx][cnt+1]&&map[nx][cnt+1]!='x') {
				output[cnt+1]=nx;
				DFS(first,nx,cnt+1,pick,visited);
			}
		}
		return false;
	}
}
