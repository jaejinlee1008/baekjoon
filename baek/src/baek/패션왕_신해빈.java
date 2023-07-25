package baek;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class ÆÐ¼Ç¿Õ_½ÅÇØºó {
	public static int count=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int test_case = Integer.parseInt(br.readLine());
		for(int i=0;i<test_case;i++) {
			count=1;
			int n = Integer.parseInt(br.readLine());
			Map<String, Integer> map = new HashMap<>();
			for(int j=0;j<n;j++) {
				String str = br.readLine();
				map.put(str.split(" ")[1], map.getOrDefault(str.split(" ")[1], 0)+1);
			}
			int[] arr = new int[map.size()];
			int idx=0;
			for(String str : map.keySet()) {
				arr[idx] = map.get(str)+1;
				idx++;
			}

			for(int j : arr) {
				count*=j;
			}
			count--;
			bw.write(Integer.toString(count));
			bw.newLine();
		}
		bw.flush();
	}
//	public static void comb(int[] arr, int[] output,boolean[] visited,int depth,int r) {
//		if(depth==r) {
//			int num=1;
//			for(int i : output) {
//				num*=i;
//			}
//			count+=num;
//			return;
//		}
//		for(int i=0;i<r;i++) {
//			if(!visited[i]) {
//				visited[i]=true;
//				output[depth] = arr[i];
//				comb(arr,output,visited,depth+1,r);
//				visited[i]=false;
//			}
//		}
//	}
}
