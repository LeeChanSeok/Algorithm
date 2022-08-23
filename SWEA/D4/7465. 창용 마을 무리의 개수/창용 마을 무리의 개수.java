import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	static int N, M;
	static int[] P;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			P = new int[N + 1];
			for(int i = 1; i < N + 1; i++)
				P[i] = i;
			
			int totalCnt = N;
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				if(union(a, b)) totalCnt--;
			}
			sb.append("#" + tc + " " + totalCnt + "\n");
		}

		bw.write(sb.toString());
		bw.close();
	}

	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot)	return false;

		P[bRoot] = aRoot;
		return true;
	}

	static int find(int x) {
		if (P[x] == x)
			return x;
		return P[x] = find(P[x]);
	}

}
