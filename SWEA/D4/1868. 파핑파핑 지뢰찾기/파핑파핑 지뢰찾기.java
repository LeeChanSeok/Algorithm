import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    final static int delta = 1000;
    final static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    final static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static int N;
    static char[][] board;
    static int[][] cntArr;
    static boolean[][] checked;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; ++tc){
            N = Integer.parseInt(br.readLine());

            board = new char[N][N];
            for(int i = 0; i < N; ++i) board[i] = br.readLine().toCharArray();

            cntArr = new int[N][N];
            for(int i = 0; i < N; ++i){
                for(int j =  0; j < N; ++j){
                    if(board[i][j] != '*') cntArr[i][j] = getCount(i, j);
                }
            }

            int cnt = 0;
            checked = new boolean[N][N];
            // 1. 주변에 지뢰 개수가 0인 좌표를 중심으로 bfs탐색
            for(int i = 0; i < N; ++i){
                for(int j = 0; j < N; ++j){
                    if(cntArr[i][j] == 0 && !checked[i][j] && board[i][j] != '*') {
                        bfs(i, j);
                        ++cnt;
                    }
                }
            }

            // 2. 방문하지 않았고 지뢰가 아닌 곳의 개수
            for(int i = 0; i < N; ++i){
                for(int j = 0; j < N; ++j){
                    if(board[i][j] == '.' && !checked[i][j]) {
                        ++cnt;
                    }
                }
            }

            System.out.printf("#%d %d\n", tc, cnt);
        }

    }

    private static void bfs(int x, int y) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(x*delta + y);
        checked[x][y] = true;

        int cur, nx, ny;
        while(!q.isEmpty()){
            cur = q.poll();
            x = cur/delta; y = cur%delta;

            for(int d = 0; d < 8; d++){
                nx = x + dx[d]; ny = y + dy[d];
                if(nx < 0 || nx >= N || ny < 0 || ny >= N || board[nx][ny] =='*' || checked[nx][ny]) continue;

                checked[nx][ny] = true;
                if(cntArr[nx][ny] == 0) q.offer(nx * delta + ny);

            }
        }
    }

    private static int getCount(int x, int y) {
        int nx, ny, cnt = 0;
        for(int d = 0; d < 8; ++d){
            nx = x + dx[d]; ny = y + dy[d];

            if(nx < 0 || nx >= N || ny < 0 || ny >= N || board[nx][ny] =='.') continue;
            ++cnt;
        }

        return cnt;
    }
}
