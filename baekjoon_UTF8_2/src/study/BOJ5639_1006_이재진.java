package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BOJ5639_1006_이재진 {
	static Map<Integer,int[]> map = new HashMap<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = null;
		List<Integer> list = new ArrayList<>();
		
		while((str = br.readLine())!=null) {
			list.add(Integer.parseInt(str));
		}
		boolean[] visited = new boolean[list.size()];
		for(int i=0;i<list.size();i++) {
			boolean flag = false;
			for(int j=i+1;j<list.size();j++) {
				if(list.get(i)>list.get(j)) {
					if(visited[j]) break;
					if(!flag) {
						int[] tmp = new int[2];
						tmp[0]=list.get(j);
						map.put(list.get(i), tmp);
						visited[j]=true;
						flag=true;
					}
				}else {
					if(visited[j]) break;
					if(flag) {
						map.get(list.get(i))[1]=list.get(j);
						visited[j]=true;
						break;
					}else {
						int[] tmp = new int[2];
						tmp[1]=list.get(j);
						map.put(list.get(i), tmp);
						visited[j]=true;
						break;
					}
				}
			}
		}
//		for(int key : map.keySet()) {
//			System.out.println(key);
//			System.out.println(Arrays.toString(map.get(key)));
//		}
		dfs(list.get(0));
	}
	
	private static void dfs(int root) {
		if(map.containsKey(root)) {
			if(map.get(root)[0]!=0) {
				dfs(map.get(root)[0]);
			}
			if(map.get(root)[1]!=0) {
				dfs(map.get(root)[1]);
			}
		}
		
		System.out.println(root);
		
	}
}
