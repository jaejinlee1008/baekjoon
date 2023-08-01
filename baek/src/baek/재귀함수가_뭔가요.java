package baek;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class ����Լ���_������ {
	public static String[] ment = {"\"����Լ��� ������?\"","\"�� ����. �������� �� �� ����⿡ �̼��� ��� ������ ����� ������ �־���.",
			"���� ������� ��� �� ���ο��� ������ ������ �߰�, ��� �����Ӱ� ����� �־���.","���� ���� ��κ� �ǾҴٰ� �ϳ�. �׷��� ��� ��, �� ���ο��� �� ���� ã�ƿͼ� ������.\""};
	public static String[] endingment = {"\"����Լ��� ������?\"","\"����Լ��� �ڱ� �ڽ��� ȣ���ϴ� �Լ����\"","��� �亯�Ͽ���."};
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = sc.nextInt();
		recursive(0,N,bw);
		bw.flush();
		bw.close();
	}
	public static void recursive(int start,int end,BufferedWriter bw) throws IOException {
		if(start==0) {
			bw.write("��� �� ��ǻ�Ͱ��а� �л��� ������ �������� ã�ư� ������.");
			bw.newLine();
		}else if(start==end) {
			
			for(int i=0;i<endingment.length;i++) {
				for(int j=0;j<end*4;j++) {
					bw.write("_");
				}
				bw.write(endingment[i]);
				bw.newLine();
			}
			
			return;
		}
		
		for(int i=0;i<ment.length;i++) {
			for(int j=0;j<start*4;j++) {
				bw.write("_");
			}
			bw.write(ment[i]);
			bw.newLine();
		}
		
		recursive(start+1,end,bw);
		for(int i=0;i<start*4;i++) {
			bw.write("_");
		}
		bw.write("��� �亯�Ͽ���.");
		bw.newLine();
	}
}
