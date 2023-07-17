package solved.ac;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class 좌표_정렬하기_2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		long N = Long.parseLong(br.readLine());
		List<String> list = new ArrayList<>();
		for(long i=0;i<N;i++) {
			list.add(br.readLine());
		}
		list.sort(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				
				if(o1.split(" ")[1].equals(o2.split(" ")[1])) {
					return Integer.parseInt(o1.split(" ")[0]) - Integer.parseInt(o2.split(" ")[0]);
				}else {
					return Integer.parseInt(o1.split(" ")[1]) - Integer.parseInt(o2.split(" ")[1]);
				}
				
			}
		});
		for(String s : list) {
			bw.write(s);
			bw.newLine();
		}
		bw.flush();
	}
}
