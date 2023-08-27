package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17406_0827_이재진 {
	static int N,M,K;
	static int[][] arr; //배열 초기상태 저장
	static int[][] input; // 어떤 부분 회전 시키는지 저장
	static boolean[] visited;
	static int min=Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N+1][M+1];
		input = new int[K][3];
		visited = new boolean[K];
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			input[i][0]=r;
			input[i][1]=c;
			input[i][2]=s;

		}
		perm(0,new int[K]);
		System.out.println(min);
	}
	private static void perm(int cnt,int[] output) { //돌릴 순서 정하기, 순열
		if(cnt==K) { //돌릴 순서를 다 찾았으면
			int[][] tmp = new int[N+1][M+1]; //임시 배열에 복사, 초기값은 변하면 안되기 때문
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=M;j++) {
					tmp[i][j]=arr[i][j];
				}
			}
//			System.out.println(Arrays.toString(output));
			for(int i=0;i<K;i++) {
				int r = input[output[i]][0];
				int c = input[output[i]][1];
				int s = input[output[i]][2];
				rotate(tmp,r-s,c-s,r+s,c+s); //임시 배열 회전
			}
//			for(int[] ar : tmp) {
//				System.out.println(Arrays.toString(ar));
//			}
			for(int i=1;i<=N;i++) {
				int sum=0;
				for(int j=1;j<=M;j++) {
					sum+=tmp[i][j];
				}
				min = Math.min(min,sum);
			}
//			System.out.println(min);
			return;
		}
		for(int i=0;i<K;i++) {
			if(!visited[i]) {
				visited[i]=true;
				output[cnt]=i;
				perm(cnt+1,output);
				visited[i]=false;
			}
		}
	}
	//테두리 부터 회전시키고 한칸씩 안쪽으로 재귀를 호출하며 회전시킨다
	private static void rotate(int[][] map,int x1, int y1, int x2, int y2) {
		if(x2-x1<=0||y2-y1<=0) { //회전시킬 수 없는 상태면 return
			return;
		}
		int tmp1 = map[x1][y2]; //회전시에 덮여씌워지는 값 미리 저장
		int tmp2 = map[x2][y2]; //회전시에 덮여씌워지는 값 미리 저장
		int tmp3 = map[x2][y1]; //회전시에 덮여씌워지는 값 미리 저장
		
		for(int i=y2;i>y1;i--) { //뒤에서부터 앞의 값으로 덮어 씌운다
			map[x1][i]=map[x1][i-1];
		}
		
		for(int i=x2;i>x1+1;i--) { //뒤에서부터 앞의 값으로 덮어 씌운다
			map[i][y2]=map[i-1][y2];
		}
		map[x1+1][y2]=tmp1; //덮어 씌워진 값에 미리 tmp에 담아둔 값을 넣는다
		
		for(int i=y1;i<y2-1;i++) { //앞에서부터 뒤에값으로 덮어 씌운다
			map[x2][i]=map[x2][i+1];
		}
		map[x2][y2-1]=tmp2; //덮어 씌워진 값에 미리 tmp에 담아둔 값을 넣는다
		
		for(int i=x1;i<x2-1;i++) { //앞에서부터 뒤에값으로 덮어 씌운다
			map[i][y1]=map[i+1][y1];
		}
		map[x2-1][y1]=tmp3; //덮어 씌워진 값에 미리 tmp에 담아둔 값을 넣는다
		rotate(map,x1+1,y1+1,x2-1,y2-1); //한 칸 안쪽을 회전시키러 함수 호출
	}
}
