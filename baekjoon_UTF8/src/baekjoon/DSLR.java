package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

class Pair {
	int num;
	char word;
	
	public Pair(int num, char word) {
		this.num = num;
		this.word = word;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public char getWord() {
		return word;
	}
	public void setWord(char word) {
		this.word = word;
	}

}

public class DSLR {
	static int A;
	static int B;
//	static Map<Integer,String> map;
	static boolean[] visited;
	static Pair[] from;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
//			map = new HashMap<>();
			visited = new boolean[10000];
			from = new Pair[10000];
			StringTokenizer st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			bw.write(BFS()+"\n");
		}
		bw.flush();
	}

	private static String BFS() {
		Queue<Pair> queue = new LinkedList<>();
//		map.put(A, "");
		visited[A]=true;
		queue.add(new Pair(A,'x'));
		int n=0;
		int D=0;
		int S=0;
		int L=0;
		int R=0;
		while(!queue.isEmpty()) {
			Pair tmp = queue.poll();
			n = tmp.getNum();
//			System.out.println(n+","+map.get(n));
			if(n==B) {
				break;
			}
			if(n!=B&&tmp.getWord()=='L') {
				D=(2*n)%10000;
				if(!visited[D]) {
					queue.add(new Pair(D,'D'));
					from[D]=new Pair(n,'D');
					visited[D]=true;
				}
				S = n==0? 9999:n-1;
				if(!visited[S]) {
					queue.add(new Pair(S,'S'));
					from[S]=new Pair(n,'S');
					visited[S]=true;
				}
				
				L = L(n);
				if(!visited[L]) {
					queue.add(new Pair(L,'L'));
					from[L]=new Pair(n,'L');
					visited[L]=true;
				}
				
			}else if(tmp.getWord()=='R') {
				D=(2*n)%10000;
				if(!visited[D]) {
					queue.add(new Pair(D,'D'));
					from[D]=new Pair(n,'D');
					visited[D]=true;
				}
				S = n==0? 9999:n-1;
				if(!visited[S]) {
					queue.add(new Pair(S,'S'));
					from[S]=new Pair(n,'S');
					visited[S]=true;
				}
				
				R = R(n);
				if(!visited[R]) {
					queue.add(new Pair(R,'R'));
					from[R]=new Pair(n,'R');
					visited[R] = true;
				}
				
			}else {
				D=(2*n)%10000;
				if(!visited[D]) {
					queue.add(new Pair(D,'D'));
					from[D]=new Pair(n,'D');
					visited[D]=true;
				}
				S = n==0? 9999:n-1;
				if(!visited[S]) {
					queue.add(new Pair(S,'S'));
					from[S]=new Pair(n,'S');
					visited[S]=true;
				}
				
				L = L(n);
				if(!visited[L]) {
					queue.add(new Pair(L,'L'));
					from[L]=new Pair(n,'L');
					visited[L]=true;
				}
				R = R(n);
				if(!visited[R]) {
					queue.add(new Pair(R,'R'));
					from[R]=new Pair(n,'R');
					visited[R] = true;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		if(visited[B]) {
			int idx=B;
			while(idx!=A) {
				stack.add(from[idx].getWord());
				idx=from[idx].getNum();
			}
		}
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		return sb.toString();
	}
	
	private static int L(int n) {
		int num=0;
		int quotient = n/1000;
		int remainder = n%1000;
		num=remainder*10+quotient;
		return num;

	}
	
	private static int R(int n) {
		int num=0;
		int quotient = n/10;
		int remainder = n%10;
		num=remainder*1000+quotient;
		return num;

	}
}
