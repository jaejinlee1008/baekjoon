package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 나이순_정렬 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long num = Integer.parseInt(br.readLine());
		List<String> list = new ArrayList<>();
		for(long i=0;i<num;i++) {
			list.add(br.readLine());
		}
		list.sort((o1,o2)->Integer.parseInt(o1.split(" ")[0])-Integer.parseInt(o2.split(" ")[0]));
		for(String s : list) {
			System.out.println(s);
		}
	}
}
