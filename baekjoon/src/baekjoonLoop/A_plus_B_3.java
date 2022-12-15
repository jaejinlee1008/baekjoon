package baekjoonLoop;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class A_plus_B_3 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		String input = "";
		int A , B;
		int sum=0;
		try {
			while((input=br.readLine())!=null)
			{
				st = new StringTokenizer(input);
				
				  A=Integer.parseInt(st.nextToken()); 
				  B=Integer.parseInt(st.nextToken());
				  sum=A+B; 
				  bw.write(sum+"\n");
				 
				
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
