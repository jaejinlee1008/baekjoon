package baekjoon;
/* summary : 레이저를 오른쪽에서 왼쪽으로 발사, 레이저를 발사한 탑보다 높이가 높은 탑이 레이저 신호를 받는다.
 * 			 레이저를 보낸 탑의 위치에 레이저를 받은 탑의 위치값을 저장, 신호를 받는 탑이 없다면 0를 저장
 * strategy : stack에 높이와 인덱스를 저장, 현재 탑의 길이가 왼쪽 탑의 길이보다 높고, 왼쪽 탑의 레이저 신호를 받는 탑보다 높으면
 * 				stack을 탐색하여 현재 탑 보다 낮은 탑들을 pop하고 현재 탑을 add, 현재 탑 보다 높은 탑을 만나면 해당 탑의 인덱스를 저장
 * note: 같은 높이의 탑은 존재하지 않음, index를 stack에 같이 저장
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class 탑 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int[] result = new int[N+1];
		Stack<int[]> stack = new Stack<>();
		int max = 1;
		for(int i=1;i<=N;i++) {
			if(stack.isEmpty()) {
				stack.add(new int[] {arr[i],i});
				result[i]=0;
			}else {
				if(stack.peek()[0]<arr[i]&&arr[i]<arr[result[i-1]]) {
					stack.add(new int[] {arr[i],i});
					result[i]=result[i-1];
				}else if(stack.peek()[0]<arr[i]&&arr[i]>arr[result[i-1]]&&arr[i]>arr[max]){
					stack.add(new int[] {arr[i],i});
					max = i;
					result[i]=0;
				}else if(stack.peek()[0]<arr[i]&&arr[i]>arr[result[i-1]]&&arr[i]<arr[max]){
					while(!stack.isEmpty()) {
						int[] tmp = stack.peek();
						if(tmp[0]<arr[i]) {
							stack.pop();
						}else {
							stack.add(new int[] {arr[i],i});
							result[i] = tmp[1];
							break;
						}
					}
				}else {
					stack.add(new int[] {arr[i],i});
					result[i]=i-1;
					
				}
			}
		}

		String answer = Arrays.toString(result);
		if(N>1) {
			bw.write(answer.substring(4,answer.length()-1).replace(",", ""));
		}else {
			bw.write(answer.substring(4,answer.length()-1));
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
