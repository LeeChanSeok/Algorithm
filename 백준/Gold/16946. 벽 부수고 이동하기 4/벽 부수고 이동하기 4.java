import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, 1, -1};
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		char[][] board = new char[N][M];
		for(int i = 0; i < N; ++i)
			board[i] = br.readLine().toCharArray();
		
		int[][] groupBoard = new int[N][M];
		
		Map<Integer, Integer> groupCnt = new HashMap<>();
		
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visit = new boolean[N][M];
		int[] cur;
		int cnt, nx, ny;
		int group = 1;
		
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < M; ++j) {
				if(board[i][j] == '1' || visit[i][j]) continue;
				
				q.clear();
				
				q.offer(new int[] {i, j});
				visit[i][j] = true;
				groupBoard[i][j] = group;
				cnt = 1;
				while(!q.isEmpty()) {
					cur = q.poll();
					
					for(int d = 0; d < 4; ++d) {
						nx = cur[0] + dx[d];
						ny = cur[1] + dy[d];
						
						if(nx < 0 || nx >= N || ny < 0 || ny >= M || visit[nx][ny] || board[nx][ny] == '1') continue;
						
						q.offer(new int[] {nx, ny});
						visit[nx][ny] = true;
						groupBoard[nx][ny] = group;
						++cnt;
					}
					
				}
				
				groupCnt.put(group, cnt);
				++group;
			}
		}
		
		Set<Integer> groupCheck = new HashSet<>();
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < M; ++j) {
				if(board[i][j] == '0') sb.append('0');
				else {
					cnt = 0;
					groupCheck.clear();
					for(int d = 0; d < 4; ++d) {
						nx = i + dx[d];
						ny = j + dy[d];
						
						if(nx < 0 || nx >= N || ny < 0 || ny >= M || board[nx][ny] == '1') continue;
						group = groupBoard[nx][ny];
						if(!groupCheck.contains(group)) {
							groupCheck.add(group);
							cnt += groupCnt.get(group);
						}
					}
					sb.append((++cnt)%10);
				}
			}
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		bw.close();

	}

}