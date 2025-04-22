package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 분수_합 {
	public static double X;
	public static double Y;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		double A = Double.parseDouble(st.nextToken());
		double B = Double.parseDouble(st.nextToken());
		st = new StringTokenizer(br.readLine());
		double C = Double.parseDouble(st.nextToken());
		double D = Double.parseDouble(st.nextToken());
		double num=0.0;
		sum(A,B,C,D);
		if(X>=Y) {
			num = gcd(X,Y);
		}else {
			num = gcd(Y,X);
		}
		int answer1 = (int)(X/num);
		int answer2 = (int)(Y/num);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(Integer.toString(answer1)+" "+Integer.toString(answer2));
		bw.flush();
	}
	
	public static void sum(double A,double B,double C,double D) {
		X = A*D+B*C;
		Y = B*D;
	}
	
	public static double gcd(double a, double b) {
		if(b==0) {
			return a;
		}
		return gcd(b,a%b);
	}
}
