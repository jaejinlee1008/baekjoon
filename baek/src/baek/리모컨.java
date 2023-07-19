package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class ¸®¸ðÄÁ {
	public static int close=-1;
	public static int min=Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String tar = br.readLine();
		int target = Integer.parseInt(tar);
		int broken = Integer.parseInt(br.readLine());
		Set<Integer> set = new HashSet<>();
		int[] button = new int[10-broken];
//		int[] output = new int[tar.length()];
		int current=100;
		if(broken>0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<broken;i++) {
				set.add(Integer.parseInt(st.nextToken()));
			}
			int idx=0;
			for(int i=0;i<10;i++) {
				if(!set.contains(i)) {
					button[idx] = i;
					idx++;
				}
			}
			min = Math.abs(target-current);
			for(int i=1;i<=tar.length()+1;i++) {
				perm(button,new int[i],0,i,target);
			}
			
			if(close==-1) {
				System.out.println(min);
			}else {
				System.out.println(Math.abs(target-close)+Integer.toString(close).length());
			}
		}
		else {
			System.out.println(Math.min(tar.length(), Math.abs(target-current)));
		}
		
	}
	
	public static void perm(int[] button, int[] output,  int dept, int r,int target) {
		if(dept==r) {
			StringBuilder sb = new StringBuilder();
			for(int i : output) {
				sb.append(Integer.toString(i));
			}
			String str = sb.toString();
			if(Math.abs(target-Integer.parseInt(str))+str.length()<min) {
				min = Math.abs(target-Integer.parseInt(str))+str.length();
				close = Integer.parseInt(str);
			}
			return;
		}
		
		for(int i=0;i<button.length;i++) {
			
			output[dept]=button[i];
			perm(button,output,dept+1,r,target);
				
		}
	}
}
