import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, M, answer;
	static int[] knows;
	static int[][] party;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		knows = new int[N+1];
		st = new StringTokenizer(br.readLine());
		int know = Integer.parseInt(st.nextToken());
		for(int i = 0; i < know; ++i) knows[Integer.parseInt(st.nextToken())] = 1;

		party = new int[M][];
		for(int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			party[i] = new int[cnt];
			for(int j = 0; j < cnt; ++j) party[i][j] = Integer.parseInt(st.nextToken());
	
		}
		
		answer = 0;
		dfs(0, 0);
		System.out.println(answer);
	}
	private static void dfs(int idx, int liar) {
		if(idx == M) {
			answer = Math.max(answer, liar);
			return;
		}
		
		List<Integer> notHeard = new LinkedList<>();
		int t = 0, f = 0;
		for(int j = 0, cnt = party[idx].length; j < cnt; ++j) {
			int num = party[idx][j];
			if(knows[num]== 1) ++t;
			else if(knows[num] == 2) ++f;
			else notHeard.add(num);
		}
		
		// 진실을 말한다
		if(f == 0) {
			for(int n : notHeard) knows[n] = 1;
			dfs(idx + 1, liar);
			for(int n : notHeard) knows[n] = 0;
		}
		
		// 거짓말을 한다
		if(t == 0) {
			for(int n : notHeard) knows[n] = 2;
			dfs(idx + 1, liar+1);
			for(int n : notHeard) knows[n] = 0;
		}
		
	}

}
