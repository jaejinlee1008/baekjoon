package baek;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 숫자_카드_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		long N = Long.parseLong(br.readLine());

		Map<String,Long> map = new HashMap<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
			String tmp = st.nextToken();
			map.put(tmp, map.getOrDefault(tmp, (long) 0)+1);
		}
		long M = Long.parseLong(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		
		while(st2.hasMoreTokens()) {
			String tmp = st2.nextToken();
			if(map.containsKey(tmp)) {
				bw.write(map.get(tmp)+" ");
			}else {
				bw.write("0 ");
			}
			
		}
		bw.flush();
	}
}
