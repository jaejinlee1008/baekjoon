package baek;

/* �����ؼ� : ���л��� ���� �ڿ����� ����� ����ġ�� ������, ���л��� ���� �ڿ����� ��ġ�� ����ġ���� ��Ī�Ǵ� ����ġ�� ������.
 * 
 * ���� : boolean�迭�� ���� ���ǿ� �°� ���� ����
 * 
 * ������ ���� : 20���� ��� ��� 
 * 
 */



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class ����ġ_�Ѱ�_���� {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		boolean[] arr = new boolean[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			if(st.nextToken().equals("1")) {
				arr[i]=true;
			}
		}
		int student = Integer.parseInt(br.readLine());
		
		
		for(int i=0;i<student;i++) {
			st = new StringTokenizer(br.readLine());
			int stu = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			
			if(stu==1) {
				for(int j=num;j<=N;j++) {
					if(j%num==0) {
						arr[j] = !arr[j];
					}
					
				}
			}else if(stu==2) {
				arr[num]=!arr[num];
				int idx=1;
				while(true) {
					
					if(num+idx<=N&&num-idx>=1&&arr[num+idx]==arr[num-idx]) {
						arr[num+idx]=!arr[num+idx];
						arr[num-idx]=!arr[num-idx];
						idx++;
					}else {
						break;
					}
				}
			}
			
		}
		for(int i=1;i<=N;i++) {
			
			if(arr[i]) {
				bw.write("1 ");
			}else {
				bw.write("0 ");
			}
			if(i%20==0) {
				bw.newLine();
			}
		}
		bw.flush();
		bw.close();
	}
}
