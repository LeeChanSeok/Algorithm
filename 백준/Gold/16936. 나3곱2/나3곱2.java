import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static long[] A, B;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception{
		input();
		pro();
	}

	private static void pro() {

		for(int i = 0; i < N; ++i) {
			visited[i] = true;
			A[0] = B[i];
			recursive(1);
			visited[i] = false;
		}
		
	}

	private static boolean recursive(int idx) {

		if(idx == N) {
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < N; ++i) sb.append(A[i] + " ");
			System.out.println(sb);
			return true;
		}
		
		// 나3
		if(A[idx - 1] % 3 == 0) {
			long num = A[idx - 1] / 3;
			for(int i = 0; i < N; ++i) {
				if(visited[i] || B[i] != num) continue;
				
				visited[i] = true;
				A[idx] = num;
				if(recursive(idx+1)) return true;
				visited[i] = false;
			}
		}
		
		// 곱2
		long num = A[idx - 1] * 2;
		for(int i = 0; i < N; ++i) {
			if(visited[i] || B[i] != num) continue;
			
			visited[i] = true;
			A[idx] = num;
			if(recursive(idx+1)) return true;
			visited[i] = false;
		}
		
		
		return false;
	}

	private static void input() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		A = new long[N];
		B = new long[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; ++i) B[i] = Long.parseLong(st.nextToken());
		
		visited = new boolean[N];
	}

}