package solved.ac;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class µ¢Ä¡ {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		String[] arr = new String[N];
		int[] rank = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = br.readLine();
		}
		for(int i=0;i<N;i++) {
			rank[i]++;
			for(int j=0;j<N;j++) {
				if(i==j) {
					continue;
				}
				if(Integer.parseInt(arr[i].split(" ")[0])<Integer.parseInt(arr[j].split(" ")[0])
						&&Integer.parseInt(arr[i].split(" ")[1])<Integer.parseInt(arr[j].split(" ")[1])) {
					rank[i]++;
				}
			}
			bw.write(rank[i]+" ");
		}
		bw.flush();
	}
}
