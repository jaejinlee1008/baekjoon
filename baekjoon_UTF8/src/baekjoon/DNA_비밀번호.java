package baekjoon;

/* summary : 입력받은 문자열의 부분문자열이 특정한 문자를 포함하는 조건과 일치하는 경우의 수 찾기
 * strategy : 입력받은 문자열과 같은 길이의 2차원 배열을 만들고
 * 			    배열에 해당 위치 까지의 A,C,G,T의 갯수를 저장해놓는다.
 * 			    부분문자열의 갯수만큼 반복문을 돌며 부분문자열이 조건을 만족하는지 확인한다
 * note : 시간초과 조심
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DNA_비밀번호 {
	static int S;
	static int P;
	static String input;
	static int count=0;
	static int[][] ACGT;
	static int[] arr = new int[4];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		ACGT = new int[S+1][4];
		input = br.readLine();
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<4;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1;i<=S;i++) {
			int num=0;
			if(input.charAt(i-1)=='A') {
				num=0;
			}else if(input.charAt(i-1)=='C') {
				num=1;
			}else if(input.charAt(i-1)=='G') {
				num=2;
			}else if(input.charAt(i-1)=='T') {
				num=3;
			}
			for(int j=0;j<4;j++) {
				ACGT[i][j] += ACGT[i-1][j]; 
			}
			ACGT[i][num]++;
		}
		
		for(int i=0;i<=S-P;i++) {
			int tmp[] = {ACGT[i+P][0]-ACGT[i][0],ACGT[i+P][1]-ACGT[i][1],ACGT[i+P][2]-ACGT[i][2],ACGT[i+P][3]-ACGT[i][3]};
			boolean stop = false;
			for(int j=0;j<4;j++) {
				if(tmp[j]<arr[j]) {
					stop=true;
					break;
				}
			}
			if(!stop) {
				count++;
			}
		}
		System.out.println(count);
	}
}
