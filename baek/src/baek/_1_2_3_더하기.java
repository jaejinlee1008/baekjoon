package baek;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _1_2_3_¥ı«œ±‚ {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N+1];
			arr[0]=0;
			arr[1]=1;
			if(N>1) {
				arr[2]=2;
			}
			if(N>2) {
				arr[3]=4;
				for(int j=4;j<=N;j++) {
					arr[j]=arr[j-1]+arr[j-2]+arr[j-3];
				}
			}
			bw.write(Integer.toString(arr[N]));
			bw.newLine();
		}
		bw.flush();
	}
}
