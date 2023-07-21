package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 나는야_포켓몬_마스터_이다솜 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Map<String, Integer> map1 = new HashMap<>();
		Map<Integer, String> map2 = new HashMap<>();
		for(int i=1;i<=N;i++) {
			String str = br.readLine();
			map1.put(str, i);
			map2.put(i, str);
		}
		for(int i=1;i<=M;i++) {
			String str = br.readLine();
			if(map1.containsKey(str)) {
				sb.append(map1.get(str)+"\n");
			}else {
				sb.append(map2.get(Integer.parseInt(str))+"\n");
			}
		}
		System.out.println(sb);
	}
}
