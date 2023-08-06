package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class AC {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			String func = br.readLine();
			int len = Integer.parseInt(br.readLine());
			String arr = br.readLine();
			String narr = arr.substring(1, arr.length()-1);
			if(len==0) {
				if(func.contains("D")) {
					bw.write("error\n");
				}else {
					bw.write(arr+"\n");
				}
				continue;
			}else if(len==1) {
				for(int j=0;j<func.length();j++) {
					if(func.charAt(j)=='D') {
						if(narr.length()>0) {
							narr="";
						}else {
							narr="error";
							break;
						}
					}
				}
				if(narr.equals("error")) {
					bw.write(narr+"\n");
				}else {
					StringBuilder sb = new StringBuilder();
					sb.append("[").append(narr).append("]");
					bw.write(sb.toString()+"\n");
				}
				continue;
			}
			Deque<Integer> dq = new LinkedList<>();
			Stack<Character> stack = new Stack<>();
			boolean stop=false;
			if(len>1) {
				String[] str = narr.split(",");
				
				for(int j=0;j<len;j++) {
					dq.add(Integer.parseInt(str[j]));
				}
				
				for(int j=0;j<func.length();j++) {
					if(func.charAt(j)=='R') {
						if(stack.isEmpty()) {
							stack.add('R');
						}else {
							stack.pop();
						}
					}else {
						if(dq.isEmpty()) {
							bw.write("error\n");
							stop=true;
							break;
						}else if(stack.isEmpty()&&!dq.isEmpty()) {
							dq.poll();
						}else if(!stack.isEmpty()&&!dq.isEmpty()) {
							dq.pollLast();
						}
					}
				}
			}
			
			if(!dq.isEmpty()) {
				int[] result = new int[dq.size()];
				int idx=0;
				if(stack.isEmpty()) {
					while(!dq.isEmpty()) {
						result[idx++]=dq.poll();
					}
				}else {
					while(!dq.isEmpty()) {
						result[idx++]=dq.pollLast();
					}
				}
				bw.write(Arrays.toString(result).replace(" ", "")+"\n");
			}else if(!stop){
				bw.write("[]\n");
			}
			
		}
		bw.flush();
	}
}
