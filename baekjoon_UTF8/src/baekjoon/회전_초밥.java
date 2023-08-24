package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 회전_초밥 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		Set<Integer> set = new HashSet<>();
		set.add(c);
		int max = Integer.MIN_VALUE;
		int[] arr = new int[n+(k-1)];
		int[] visited = new int[d+1];
		for(int i=0;i<n;i++) {
			int input = Integer.parseInt(br.readLine());
			if(i<k-1) {
				arr[n+i]=input;
			}
			arr[i] = input;
		}
		int left=0;
		int right=0;
		while(right<arr.length) {
			if(right-left<k-1) {
				set.add(arr[right]);
				visited[arr[right]]++;
				right++;
			}
			if(right-left==k-1) {
				set.add(arr[right]);
				visited[arr[right]]++;
//				System.out.println(left+","+right);
//				System.out.println(set);
				max = Math.max(set.size(),max);
				if(arr[left]!=c&&visited[arr[left]]==1) {
					set.remove(arr[left]);
					visited[arr[left]]--;
				}else if(visited[arr[left]]>1) {
					visited[arr[left]]--;
				}
				left++;
				right++;
			}
			
		}
		System.out.println(max);
	}
}
