package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class 찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] text = br.readLine().toCharArray();
		char[] pattern = br.readLine().toCharArray();
		
		int tlength = text.length, plength = pattern.length;
		// 1) 실패함수 만들기
		int fail[] = new int[plength];
		for(int i=1, j=0; i<plength;i++) { // 패턴 길이만큼
			while(j>0 && pattern[i]!=pattern[j]) { //비교값이 서로 다르면
				j = fail[j-1];
			}
			if(pattern[i]==pattern[j]) {
				fail[i] = ++j;
			}else {
				fail[i]=0;
			}
		}
//		System.out.println(Arrays.toString(fail));
		int cnt=0;
		ArrayList<Integer> list = new ArrayList<>();
		
		//2) 텍스트와 비교(i:텍스트 인덱스, j: 패턴 인덱스)
		for(int i=0,j=0;i<tlength;i++) {
			while(j>0 && text[i]!=pattern[j]) { //비교값이 서로 다르면
				j = fail[j-1];
			}
			if(text[i]==pattern[j]) {
				if(j==plength-1) { //패턴의 마지막 인덱스라면
					cnt++;//일치 회수 증가
					list.add((i+1)-plength+1); //패턴일치가 발생한 인덱스
					j=fail[j];//현재까지 맞았으므로 j인덱스 옮겨 놓음
				}else {
					j++;
				}
			}
		}
		
		System.out.println(cnt);
		if(cnt>0) {
			for(int i : list) {
				System.out.print(i+" ");
			}
		}
	}
}
