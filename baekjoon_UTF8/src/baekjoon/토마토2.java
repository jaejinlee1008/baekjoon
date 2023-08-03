package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토2 {
	static int M;
	static int N;
	static int H;
	static int blankcount=0;
	static List<int[][]> arr;
	static List<boolean[][]> visited;
	static int max=Integer.MIN_VALUE;
	static List<int[]> list;
	static int[] dx= {0,0,0,0,1,-1}; //위,아래,좌,우,앞,뒤
	static int[] dy= {0,0,-1,1,0,0};
	static int[] dz= {1,-1,0,0,0,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		arr = new ArrayList<>();
		visited = new ArrayList<>();
		for(int i=0;i<H;i++) {
			arr.add(new int[N][M]);
			visited.add(new boolean[N][M]);
		}
		list = new ArrayList<>();
		for(int k=0;k<H;k++) {
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				
				for(int j=0;j<M;j++) {
					arr.get(k)[i][j]=Integer.parseInt(st.nextToken());
					if(arr.get(k)[i][j]==1) {
						list.add(new int[] {i,j,k});
						visited.get(k)[i][j]=true;
					}else if(arr.get(k)[i][j]==-1) {
						blankcount++;
						visited.get(k)[i][j]=true;
					}
				}
			}
		}
		
		if(list.size()==((N*M*H)-blankcount)) {
			System.out.println("0");
			return;
		}
		
		Queue<List<int[]>> queue = new LinkedList<>();
		queue.add(list);
		while(!queue.isEmpty()) {
			List<int[]> nlist = new ArrayList<>();
			for(int[] tmp : queue.poll()) {
				for(int i=0;i<6;i++) {
					int nx = tmp[0]+dx[i];
					int ny = tmp[1]+dy[i];
					int nz = tmp[2]+dz[i];
					
					if(nx>=0&&nx<N&&ny>=0&&ny<M&&nz>=0&&nz<H&&!visited.get(nz)[nx][ny]&&arr.get(nz)[nx][ny]==0) {
						nlist.add(new int[] {nx,ny,nz});
						arr.get(nz)[nx][ny]=arr.get(tmp[2])[tmp[0]][tmp[1]]+1;
						visited.get(nz)[nx][ny]=true;
						max = Math.max(max, arr.get(nz)[nx][ny]);
					}
				}
			}
			if(nlist.size()>0) {
				queue.add(nlist);
			}
		}
		for(int k=0;k<H;k++) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(!visited.get(k)[i][j]&&arr.get(k)[i][j]==0) {
						System.out.println("-1");
						return;
					}
				}
			}
		}
		
		System.out.println(max-1);
	}
}
