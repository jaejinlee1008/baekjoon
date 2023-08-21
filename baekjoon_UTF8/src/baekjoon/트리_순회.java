package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class 트리_순회 {
	static Map<Character,List<Character>> map = new HashMap<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N  = Integer.parseInt(br.readLine().trim());
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			List<Character> tmp = new ArrayList<>();
			char a = st.nextToken().charAt(0);
			char b = st.nextToken().charAt(0);
			char c = st.nextToken().charAt(0);
			tmp.add(b);
			tmp.add(c);
			map.put(a, tmp);
		}
		DFS1('A');
		System.out.println();
		DFS2('A');
		System.out.println();
		DFS3('A');
	}
	private static void DFS1(char root) {
		System.out.print(root);
		if(map.get(root).get(0)!='.') {
			DFS1(map.get(root).get(0));
		}
		if(map.get(root).get(1)!='.') {
			DFS1(map.get(root).get(1));
		}
	}
	private static void DFS2(char root) {
		
		if(map.get(root).get(0)!='.') {
			DFS2(map.get(root).get(0));
		}
		System.out.print(root);
		if(map.get(root).get(1)!='.') {
			DFS2(map.get(root).get(1));
		}
	}
	private static void DFS3(char root) {
		
		if(map.get(root).get(0)!='.') {
			DFS3(map.get(root).get(0));
		}
		if(map.get(root).get(1)!='.') {
			DFS3(map.get(root).get(1));
		}
		System.out.print(root);
	}
}
