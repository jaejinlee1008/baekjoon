package study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ20187_0815_이재진 {
	static int k;
	static char[] input;
	static int[][] map;
	static int h;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		k = Integer.parseInt(br.readLine());
		input = new char[2*k];
		input = br.readLine().replace(" ", "").toCharArray();
		h = Integer.parseInt(br.readLine());
		map = new int[(int)Math.pow(2, k)][(int)Math.pow(2, k)];
		recursive(0,0,(int)Math.pow(2, k),0,(int)Math.pow(2, k));
		for(int[] arr: map) {
			System.out.println(Arrays.toString(arr).substring(1,Arrays.toString(arr).length()-1).replace(",", ""));
		}
	}
	private static void recursive(int idx, int x1, int x2, int y1, int y2) {
//		System.out.println(idx+","+x1+","+x2+","+y1+","+y2);
		if(idx==2*k) {
			map[x1][y1] = h; //다 접고 최종 위치에 구멍뚫리는 위치 저장
			return;
		}
		if(input[idx]=='D') {
//			System.out.println(idx+1+","+(x1+x2)/2+","+x2+","+y1+","+y2);
			
			recursive(idx+1,(x1+x2)/2,x2,y1,y2); //아래로 접는다, 접는횟수++, 시작 x값 변경
			for(int i=x1;i<(x1+x2)/2;i++) { //접은것을 다시 펼치면서 값을 대칭한다 아래로 접었으니 위에서부터 현재길이의 반까지 탐색하며 값을 채운다
				for(int j=y1;j<y2;j++) {
					map[i][j] = fold(map[x1+x2-(i+1)][j],1); //현재 값을 대칭되는 값으로 변경한다
				}
			}
		}else if(input[idx]=='U') {
//			System.out.println(idx+1+","+x1+","+(x1+x2)/2+","+y1+","+y2);
			recursive(idx+1,x1,(x1+x2)/2,y1,y2); //위로 접는다, 접는횟수++, 시작 x값 변경
			for(int i=(x1+x2)/2;i<x2;i++) {
				for(int j=y1;j<y2;j++) {
					map[i][j] = fold(map[x1+x2-(i+1)][j],1);
				}
			}
		}else if(input[idx]=='R') {
//			System.out.println(idx+1+","+x1+","+x2+","+(y1+y2)/2+","+y2);
			recursive(idx+1,x1,x2,(y1+y2)/2,y2);
			for(int i=x1;i<x2;i++) {
				for(int j=y1;j<(y1+y2)/2;j++) {
					map[i][j] = fold(map[i][y1+y2-(j+1)],0);
				}
			}
		}else {
//			System.out.println(idx+1+","+x1+","+x2+","+y1+","+(y1+y2)/2);
			recursive(idx+1,x1,x2,y1,(y1+y2)/2);
			for(int i=x1;i<x2;i++) {
				for(int j=(y1+y2)/2;j<y2;j++) {
					map[i][j] = fold(map[i][y1+y2-(j+1)],0);
				}
			}
		}
		
	}
	private static int fold(int num,int dir) {
		if(dir==0) { //세로 접기
			if(num==0) {
				return 1;
			}else if(num==1) {
				return 0;
			}else if(num==2) {
				return 3;
			}else {
				return 2;
			}
		}else{ //가로 접기
			if(num==0) {
				return 2;
			}else if(num==1) {
				return 3;
			}else if(num==2) {
				return 0;
			}else {
				return 1;
			}
		}
	}
}
