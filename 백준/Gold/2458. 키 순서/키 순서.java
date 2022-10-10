import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Student{
		int idx;
		List<Integer> prev, next;
		public Student(int idx) {
			super();
			this.idx = idx;
			prev = new LinkedList<>();
			next = new LinkedList<>();
		}
		
	}
	
	static int cnt;
	static boolean[] visit;
	static Student[] students;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N, M, a, b, ans;
			
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		students = new Student[N+1];
		for(int i = 1; i <= N; ++i)
			students[i] = new Student(i); 
		
		for(int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			students[a].next.add(b);
			students[b].prev.add(a);
		}
		
		ans = 0;
		visit = new boolean[N+1];
		for(int i = 1; i <= N; ++i) {
			cnt = 0;
			Arrays.fill(visit, false);
			nextDFS(i);
			Arrays.fill(visit, false);
			prevDFS(i);
			
			if(--cnt == N) ++ans;
		}
			
			System.out.println(ans);

	}
	
	private static void nextDFS(int i) {
		visit[i] = true;
		++cnt;
		for(int next : students[i].next) {
			if(!visit[next]) nextDFS(next);
		}
		
	}
	
	private static void prevDFS(int i) {
		visit[i] = true;
		++cnt;
		for(int prev : students[i].prev) {
			if(!visit[prev]) prevDFS(prev);
		}
	}

}