package baekjoonLoop;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class A_plus_B_2 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int A , B;
		try {
			int testcase = Integer.parseInt(br.readLine());
			for(int i=1;i<=testcase;i++)
			{
				st = new StringTokenizer(br.readLine());
				A=Integer.parseInt(st.nextToken());
				B=Integer.parseInt(st.nextToken());
				bw.write("Case #" + i + ": " + A + " + " + B + " = " + (A+B)+"\n");
				
				
			}
		} catch (NumberFormatException e) {
			
		} catch (IOException e) {
			
		}
		try {
			bw.flush();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
