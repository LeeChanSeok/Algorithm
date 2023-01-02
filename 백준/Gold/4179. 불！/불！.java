import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        char[][] board = new char[R][C];

        Queue<int[]> J = new LinkedList<>();
        Queue<int[]> F = new LinkedList<>();

        for(int i = 0; i < R; ++i)
            board[i] = br.readLine().toCharArray();

        char c;
        for(int i = 0; i < R; ++i){
            for(int j = 0; j < C; ++j){
                c = board[i][j];

                if(c == 'J'){
                    board[i][j] = '.';
                    J.offer(new int[]{i, j});
                }
                else if(c == 'F') F.offer(new int[]{i, j});

            }
        }

        int ans = bfs(J, F, board);
        if(ans == -1) System.out.println("IMPOSSIBLE");
        else System.out.println(ans);
    }

    private static int bfs(Queue<int[]> J, Queue<int[]> F, char[][] board) {

        boolean[][] visit = new boolean[R][C];
        visit[J.peek()[0]][J.peek()[1]] = true;

        int fSize, jSize;
        int x, y, nx, ny;
        int[] cur;
        int cnt = 1;
        while(!J.isEmpty()){
            // J 이동
            jSize = J.size();
            while(jSize-- > 0){
                cur = J.poll();
                x = cur[0]; y = cur[1];
                if(board[x][y] == 'F') continue;
                if(x == 0 || x == R-1 || y == 0 || y == C-1) return cnt;

                for(int d = 0; d < 4; ++d){
                    nx = x + dx[d];
                    ny = y + dy[d];
                    if(nx >= 0 && nx < R && ny >= 0 && ny < C && board[nx][ny] == '.' && !visit[nx][ny]){
                        visit[nx][ny] = true;
                        J.offer(new int[]{nx, ny});
                    }
                }
            }

            // Fire 이동
            fSize = F.size();
            while(fSize-- > 0){
                cur = F.poll();
                x = cur[0]; y = cur[1];
                for(int d = 0; d < 4; ++d){
                    nx = x + dx[d];
                    ny = y + dy[d];
                    if(nx >= 0 && nx < R && ny >= 0 && ny < C && board[nx][ny] == '.'){
                        board[nx][ny] = 'F';
                        F.offer(new int[]{nx, ny});
                    }
                }
            }

            ++cnt;
        }

        return -1;
    }
}
