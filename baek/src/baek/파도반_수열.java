package baek;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 파도반_수열 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		long test_case = Long.parseLong(br.readLine());
		for(long i=0;i<test_case;i++) {
			int N = Integer.parseInt(br.readLine());
			long[] arr = new long[N+1];
			arr[0]=0;
			arr[1]=1;
			if(N>1) {
				arr[2]=1;
				for(int j=3;j<=N;j++) {
					arr[j]=arr[j-2]+arr[j-3];
				}
			}
			bw.write(Long.toString(arr[N]));
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
