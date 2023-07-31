package baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 오목 {
	static char[][] map = new char[19][19];
    static int[] dx = {1, 0, 1, -1}; //우측아래, 가로, 세로, 우측위
    static int[] dy = {1, 1, 0, 1};

	public static void main(String[] args) throws Exception {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	        for(int i=0; i<19; i++) {
	            String input = br.readLine().replace(" ", "");

	            for(int j=0; j<19; j++) {
	                map[i][j] = input.charAt(j);
	            }
	        }

	        for(int i=0; i<19; i++) {
	            for(int j=0; j<19; j++) {
	                if(map[i][j]!='0') {
	                    for(int k=0; k<4; k++) {
	                        int cnt = bfs(i, j, k);

	                        if(cnt==5) {
	                            System.out.println(map[i][j]);
	                            System.out.println((i+1)+" "+(j+1));
	                            return;
	                        }
	                    }
	                }
	            }
	        }

	        System.out.println(0);
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		char[][] board = new char[19][19];
//		int [][] d = {{0,1}, {1,0}, {1,1}, {-1,1}};
//		
//		//		board 입력받기
//		for (int i = 0; i < 19; i++) {
//			String input = br.readLine();
//			for (int j = 0, index = 0; j < 19; index += 2, j++) {
//				board[i][j] = input.charAt(index);
//			}
//		}
//		
//		
//		// 모든 칸에 대해 오목 완성 찾기		
//		for (int j = 0; j < 19; j++) {
//			for (int i = 0; i < 19; i++) {
//				if (board[i][j] == '1' || board[i][j] == '2') {
//					for (int k = 0; k < 4; k++) {
//						int ax = i; // x좌표
//						int ay = j; // y좌표
//						int cnt = 1; // 일치하는 바둑알의 개수
//						
//						// 증가하는 방향 탐색
//						while (true) {
//							ax += d[k][0];
//							ay += d[k][1];
//							if ( 0 <= ax && ax < 19 && 0 <= ay && ay < 19) {
//								if(board[i][j] == board[ax][ay])cnt ++;
//								else {
//									break;
//								}
//							} else break;
//						}
//						ax = i;
//						ay = j;
//						
//						// 증가하는 방향의 반대방향 탐색
//						while( true) {
//							ax -= d[k][0];
//							ay -= d[k][1];
//							if ( 0 <= ax && ax < 19 && 0 <= ay && ay < 19) {
//								if(board[i][j] == board[ax][ay])cnt ++;
//								else break;
//
//							} else break;
//						}
//						
//						// 같은 오목눈이 5개라면
//						if (cnt == 5) {
//							System.out.println(board[i][j]);
//							System.out.println((i+1) + " " + (j+1));
//							return;
//						}
//						
//					}
//				}
//			}
//		}
//		
////		아무도 이기지 않았을 경우
//		System.out.println(0); 	
	
	}
	public static int bfs(int x, int y, int idx) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(x, y, 1));
        int max = 0;

        while(!queue.isEmpty()) {
            Pair temp = queue.poll();
            max = Math.max(temp.cnt, max);

            int nx = temp.x+dx[idx];
            int ny = temp.y+dy[idx];

            if(nx<0 || nx>=19 || ny<0 || ny>=19 || map[nx][ny]!=map[temp.x][temp.y]) continue;

            queue.add(new Pair(nx, ny, temp.cnt+1));
        }

        if(max==5) {
            int nx = x-dx[idx];
            int ny = y-dy[idx];
            if(nx>=0 && nx<19 && ny>=0 && ny<19 && map[nx][ny]==map[x][y])
                max++;
        }

        return max;
    }

    public static class Pair {
        int x;
        int y;
        int cnt;

        public Pair(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}
