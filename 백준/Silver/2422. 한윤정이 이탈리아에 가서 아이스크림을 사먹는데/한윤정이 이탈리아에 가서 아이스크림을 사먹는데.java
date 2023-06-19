import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static Set<Integer>[] icecream;
	static int[] pick; 
	static int answer;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		icecream = new Set[N+1];
		for(int i = 1; i <= N; ++i) {
			icecream[i] = new HashSet<>();
		}
		
		int a, b;
		for(int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			icecream[a].add(b);
			icecream[b].add(a);
		}

		pick = new int[3];
		
		solution(1, 0);
		System.out.println(answer);
		
	}

	private static void solution(int idx, int cnt) {

		if(cnt == 3) {
			answer++;
			return;
		}
		
		if(idx > N) return;
		
		if(isPick(idx, cnt)) {
			pick[cnt] = idx;
			solution(idx+1, cnt+1);
		}
		
		solution(idx+1, cnt);
		
	}

	private static boolean isPick(int idx, int cnt) {

		for(int i = 0; i < cnt; ++i) {
			if(icecream[idx].contains(pick[i])) return false;
		}
		return true;
	}

}