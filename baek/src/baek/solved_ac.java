package baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class solved_ac {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());
		List<Integer> list = new ArrayList<>();
		for(long i=0;i<n;i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		Collections.sort(list);
		long sum=0;
		for(long i=Math.round(n*0.15);i<n-Math.round(n*0.15);i++) {
			sum+=list.get((int) i);
		}
		int answer = Math.round((float)sum/(n-(2*Math.round(n*0.15))));
		System.out.println(answer);
	}
}
