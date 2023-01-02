import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static int N, M, P;
	static final int delta = 1000;
	static int p1Cnt, p2Cnt;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] count = new int[P];
		int[] S = new int[P];
		for(int i = 0; i < P; ++i)
			S[i] = Integer.parseInt(st.nextToken());

		Set<Integer>[] setArr = new HashSet[P];
		for (int i = 0; i < P; ++i) {
			setArr[i] = new HashSet<>();
		}

		char[][] board = new char[N][M];
		for (int i = 0; i < N; ++i)
			board[i] = br.readLine().toCharArray();

		while (true) {
			
			clearSetList(setArr);
			findCastle(board, setArr);
			if(!expandCastle(board, setArr, S)) break;
		}
		
		countCastle(board, count);
		
		for(int i = 0; i < P; i++) System.out.printf("%d ", count[i]);

	}

	private static void countCastle(char[][] board, int[] count) {
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < M; ++j) {
				if(board[i][j] != '#' && board[i][j] != '.') ++count[(int)(board[i][j] - '0')-1];
			}
		}
		
	}

	private static boolean expandCastle(char[][] board, Set<Integer>[] setArr, int[] S) {
		
		boolean isExpand = false;
		for(int i = 0; i < P; ++i) {
			isExpand |= bfs(board, setArr[i], i, S[i]);
		}
		
		return isExpand;
	}

	private static boolean bfs(char[][] board, Set<Integer> poses, int idx, int s) {
		Queue<Integer> q = new LinkedList<>(poses);
		
		boolean isMove = false;
		
		char c = (char)(idx + '1');
		int qSize, cnt = 0;
		int x, y, nx, ny, cur, next;
		while(!q.isEmpty()) {
			if(cnt == s) break;
			
			qSize = q.size();
			while(qSize-- > 0) {
				cur = q.poll();
				x = cur/delta; y = cur%delta;
				
				for(int d = 0; d < 4; ++d) {
					nx = x + dx[d];
					ny = y + dy[d];
					next = nx * delta + ny;
					if(nx < 0 || nx >= N || ny < 0 || ny >= M || board[nx][ny] != '.') continue;
					board[nx][ny] = c;
					q.offer(next);
					isMove = true;
				}
				
			}
			++cnt;
		}
		
		return isMove;
	}

	private static void clearSetList(Set<Integer>[] setArr) {
		
		for(int i = 0; i < P; ++i) {
			setArr[i].clear();
		}
	}

	private static void findCastle(char[][] board, Set<Integer>[] setArr) {

		int idx;
		int nx, ny;
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				if (board[i][j] == '.' || board[i][j] == '#')	continue;
				idx = (int)(board[i][j]-'0')-1;
				
				for (int d = 0; d < 4; ++d) {

					nx = i + dx[d];
					ny = j + dy[d];

					if (nx >= 0 && nx < N && ny >= 0 && ny < M && board[nx][ny] == '.') {
						setArr[idx].add(i*delta + j);
						break;
					}

				}

			}
		}

	}

}