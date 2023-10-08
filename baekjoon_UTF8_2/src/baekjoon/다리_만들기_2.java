package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 다리_만들기_2 {
	
	static class Edge implements Comparable<Edge>{
		int from;
		int to;
		int weight;
		

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
			
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}

		

		
	}
	static int N,M,cnt;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static List<Edge> edgeList;
	static List<List<int[]>> list;
	static int[] parents;
	
	static void make() {
		parents = new int[cnt];
		for(int i=0;i<cnt;i++) {
			parents[i] = i;
		}
	}
	
	static int find(int a) {
		if(parents[a]==a) return a;
		return parents[a] = find(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int aroot = find(a);
		int broot = find(b);
		if(aroot == broot) return false;
		parents[broot] = aroot;
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		list = new ArrayList<>();
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==1&&!visited[i][j]) {
					list.add(new ArrayList<>());
					bfs(i, j);
				}
			}
		}
//		for(List<int[]> li : list) {
//			for(int[] ar : li) {
//				System.out.println(Arrays.toString(ar));
//			}
//			System.out.println();
//		}
		edgeList = new ArrayList<>();
		getDistance();
		
		Collections.sort(edgeList);
		make();
		
		int result = 0; 
		int count=0;
		for(Edge edge : edgeList) {
			if(union(edge.from,edge.to)) {
				result+=edge.weight;
				if(++count==cnt-1) break;
			}
		}
		if(result==0||count!=cnt-1) {
			System.out.println(-1);
		}else {
			System.out.println(result);
		}
		
		
	}
	private static void bfs(int x,int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x,y});
		visited[x][y]=true;
		boolean flag=false;
		for(int j=0;j<4;j++) {
			int nnx = x+dx[j];
			int nny = y+dy[j];
			if(nnx>=0&&nnx<N&&nny>=0&&nny<M&&map[nnx][nny]==0) {
				flag=true;
			}
		}
		if(flag) {
			list.get(cnt).add(new int[] {x,y});
		}
		
		while(!queue.isEmpty()) {
			int[] tmp = queue.poll();
			for(int i=0;i<4;i++) {
				int nx = tmp[0]+dx[i];
				int ny = tmp[1]+dy[i];
				if(nx>=0&&nx<N&&ny>=0&&ny<M&&map[nx][ny]==1&&!visited[nx][ny]) {
					visited[nx][ny]=true;
					queue.add(new int[] {nx,ny});
					flag=false;
					for(int j=0;j<4;j++) {
						int nnx = nx+dx[j];
						int nny = ny+dy[j];
						if(nnx>=0&&nnx<N&&nny>=0&&nny<M&&map[nnx][nny]==0) {
							flag=true;
						}
					}
					if(flag) {
						list.get(cnt).add(new int[] {nx,ny});
					}
					
				}
			}
		}
		cnt++;
	}
	
	private static void getDistance() {
		for(int i=0;i<cnt;i++) {
			for(int j=i+1;j<cnt;j++) {
				int len = Integer.MAX_VALUE;
				boolean flag =true;
				for(int[] tmp : list.get(i)) {
					for(int[] tmp2 : list.get(j)) {
//						System.out.println(Arrays.toString(tmp));
//						System.out.println(Arrays.toString(tmp2));
//						System.out.println("비교");
						if(tmp[0]==tmp2[0]) {
							flag = true;
							for(int k=Math.min(tmp[1], tmp2[1])+1;k<=Math.max(tmp[1], tmp2[1])-1;k++) {
								if(map[tmp[0]][k]==1) {
									flag=false;
									break;
								}
							}
							if(!flag) continue;
							if(Math.abs(tmp[1]-tmp2[1])>2&&len>Math.abs(tmp[1]-tmp2[1])) {
								len = Math.abs(tmp[1]-tmp2[1]);

							}
						}else if(tmp[1]==tmp2[1]) {
							flag = true;
							for(int k=Math.min(tmp[0], tmp2[0])+1;k<=Math.max(tmp[0], tmp2[0])-1;k++) {
								if(map[k][tmp[1]]==1) {
									flag=false;
									break;
								}
							}
							if(!flag) continue;
							if(Math.abs(tmp[0]-tmp2[0])>2&&len>Math.abs(tmp[0]-tmp2[0])) {
								len = Math.abs(tmp[0]-tmp2[0]);
							}
						}
					}
				}
				if(len!=Integer.MAX_VALUE&&len>2) {
//					System.out.println(i+"to"+j+"거리 : " + (len-1));
					edgeList.add(new Edge(i,j,len-1));
				}
			}
		}
	}
}
