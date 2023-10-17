package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ13335_1017_이재진 {
	static int n,w,L;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        Deque<int[]> queue = new LinkedList<>();
        Deque<int[]> load = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            queue.add(new int[] { Integer.parseInt(st.nextToken()), w});
        }
        int time = 0;
        int curweight = 0;
        while(!queue.isEmpty()) {
            int size = load.size();
            for(int i=0;i<size;i++) {
                int[] tmp = load.poll();
                if(tmp[1]==1) {
                    curweight-=tmp[0];

                }else {
                    load.add(new int[] {tmp[0],tmp[1]-1});
                }
            }
            if(curweight+queue.peek()[0]<=L) {
                curweight+=queue.peek()[0];
                load.add(new int[] {queue.peek()[0],queue.poll()[1]});
            }
            time++;
        }


        System.out.println(time+load.pollLast()[1]);
	}
}
