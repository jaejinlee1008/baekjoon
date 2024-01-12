package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 용액 {
    static int N;
    static int key = 2000000001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] input = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++){
            input[i] = Integer.parseInt(st.nextToken());
        }
        Map<Integer,int[]> map = new HashMap<>();
        int left = 1;
        int right = N;
        while(left<right){
            int sum = (input[left]+input[right]);
            int abs = Math.abs(sum);
            if(abs<=key){
                key = abs;
                map.put(key,new int[]{input[left],input[right]});
            }
            if(sum==0){
                System.out.println(input[left]+" "+input[right]);
                return;
            }else if(sum<0){
                if(left<N)
                    left++;
            }else{
                if(right>1)
                    right--;
            }
        }
        System.out.println(Arrays.toString(map.get(key)));
    }
}

