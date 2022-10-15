import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static class Chip{
		int r, c, dir;

		public Chip(int r, int c, int dir) {
			super();
			this.r = r;
			this.c = c;
			this.dir = dir;
			
		}
		
	}
	
	static int N, K;
	static Chip[] chips;
	static char board[][];
	static List<Chip>[][] chipBoard;
	
	static final int[] dr = {0, 0, -1, 1};
	static final int[] dc = {1, -1, 0, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		board = new char[N][N];
		for(int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; ++j) {
				board[i][j] = st.nextToken().charAt(0);
			}
		}
		
		chipBoard = new LinkedList[N][N];
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < N; ++j) 
				chipBoard[i][j] = new LinkedList<>();
		}

		Chip chip;
		chips = new Chip[K];
		int r, c, d;
		for(int i = 0; i < K; ++i) {
			st = new StringTokenizer(br.readLine());
			
			r = Integer.parseInt(st.nextToken())-1;
			c = Integer.parseInt(st.nextToken())-1;
			d = Integer.parseInt(st.nextToken())-1;
			
			chip = new Chip(r, c, d);
			
			chips[i] = chip;
			chipBoard[r][c].add(chip);
		}
			
		int answer = simulation();
		System.out.println(answer);
		
	}

	private static int simulation() {

		int turn = 1000;
		Chip chip, temp;
		int r, c, dir, nr, nc;
		LinkedList<Chip> movelist = new LinkedList<>();
		Iterator<Chip> iter;
		while(turn-- >0) {
			
			// 1. 1번 말부터 K번 말까지 순서대로 이동
			for(int i = 0; i < K; ++i) {
				movelist.clear();
				
				// i번 째 말
				chip = chips[i];
				
				if(chipBoard[chip.r][chip.c].get(0) != chip ) continue;
				
				r = chip.r; c = chip.c; dir = chip.dir;
				// A번 말이 이동하려는 칸
				nr = r + dr[dir]; nc = c + dc[dir];

				// 체스판 밖 or 파란색				
				if (nr < 0 || nr >= N || nc < 0 || nc >= N || board[nr][nc] == '2') {
					if((dir& 1) == 0) dir+= 1;
					else dir-=1;
					
					chip.dir = dir;				
					nr = r + dr[dir]; nc = c + dc[dir];
				}
				
				// 체스판 밖 or 파란색
				if (nr < 0 || nr >= N || nc < 0 || nc >= N || board[nr][nc] == '2') continue;
				// 흰색
				else if(board[nr][nc] == '0') {
					// 이동
					iter = chipBoard[r][c].iterator();
					while(iter.hasNext()) {
						temp = iter.next();
						movelist.add(temp);
						iter.remove();
					}
				}
				
				// 빨간색
				else if(board[nr][nc] == '1') {
					// 이동
					iter = chipBoard[r][c].iterator();
					while(iter.hasNext()) {
						temp = iter.next();
						movelist.addFirst(temp);
						iter.remove();
					}
					
				}

				for(Chip ch : movelist) {
					ch.r = nr; ch.c = nc;
				}
				
				chipBoard[nr][nc].addAll(movelist);
				if(chipBoard[nr][nc].size() >= 4) return 1000 - turn;
			}
			
		}
		
		return -1;

	}

}