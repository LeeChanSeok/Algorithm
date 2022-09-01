import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int N, M, R;
	static int[][] arr, new_arr;

	static final int[] dr = { 1, 0, -1, 0 };
	static final int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		new_arr = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		
		
		rotate();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++)
				sb.append(new_arr[i][j] + " ");
			sb.append("\n");
		}

		bw.write(sb.toString());
		bw.close();

	}

	private static void rotate() {

		for (int s = 0, sSize = Math.min(N, M) / 2; s < sSize; s++) {
			// 원소의 수 및 반복을 제거한 회전의 수
			int cnt = (N-1-s*2) *2 + (M-1-s*2)*2;
			int r = R % cnt;
			
			// r번 회전시의 end위치 찾기.
			int sr, sc, er, ec;
			sr = sc = er = ec = s;
			
			int move = 0;
			int eDir = 0;
			while(move++ < r) {
				int nr = er + dr[eDir];
				int nc = ec + dc[eDir];
				
				if(!inRange(nr,nc,s)) {
					eDir = (++eDir)%4;
					nr = er + dr[eDir];
					nc = ec + dc[eDir];
				}
				er = nr;
				ec = nc;
			}
			
			// end 위치 찾기 완료
			int sDir = 0;
			move = 0;
			while(move++ < cnt) {
				new_arr[er][ec] = arr[sr][sc];
				
				//s위치 이동
				int nsr = sr + dr[sDir];
				int nsc = sc + dc[sDir];
				if(!inRange(nsr,nsc, s)) {
					sDir = (++sDir)%4;
					nsr = sr + dr[sDir];
					nsc = sc + dc[sDir];
				}
				
				//e위치이동
				int ner = er + dr[eDir];
				int nec = ec + dc[eDir];
				if(!inRange(ner, nec, s)) {
					eDir = (++eDir)%4;
					ner = er + dr[eDir];
					nec = ec + dc[eDir];
				}
			
				sr = nsr;
				sc = nsc;
				er = ner;
				ec = nec;
			}

		}

	}
	
	private static boolean inRange(int r, int c, int s) {
		if(r < 0+s || r >= N-s || c < 0+s || c >= M-s) return false;
		return true;
	}
	
}