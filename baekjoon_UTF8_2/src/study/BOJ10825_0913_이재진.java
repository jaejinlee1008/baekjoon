package study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ10825_0913_이재진 {
	static class Student implements Comparable<Student>{
		String name;
		int a; //국어
		int b; //영어
		int c; //수학
		
		public Student(String name, int a, int b, int c) {
			super();
			this.name = name;
			this.a = a;
			this.b = b;
			this.c = c;
		}

		@Override
		public int compareTo(Student o) {
			
			if(this.a==o.a) {
				if(this.b==o.b) {
					if(this.c==o.c) {
						return this.name.compareTo(o.name);
					}else {
						return Integer.compare(o.c, this.c);
					}
				}else {
					return Integer.compare(this.b, o.b);
				}
			}else {
				return Integer.compare(o.a, this.a);
			}
			
		}
		
	}
	static Student[] studentList;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		studentList = new Student[N];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			studentList[i] = (new Student(st.nextToken(),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		Arrays.sort(studentList);
		for(int i=0;i<N;i++) {
			bw.write(studentList[i].name+"\n");
		}
		bw.flush();
	}
}
