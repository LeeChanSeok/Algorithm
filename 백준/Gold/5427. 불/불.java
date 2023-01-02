import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int W, H;
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; ++tc) {

            st = new StringTokenizer(br.readLine());

            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            char[][] board = new char[H][W];

            Queue<int[]> S = new LinkedList<>();
            Queue<int[]> F = new LinkedList<>();

            for (int i = 0; i < H; ++i)
                board[i] = br.readLine().toCharArray();

            char c;
            for (int i = 0; i < H; ++i) {
                for (int j = 0; j < W; ++j) {
                    c = board[i][j];

                    if (c == '@') {
                        board[i][j] = '.';
                        S.offer(new int[]{i, j});
                    } else if (c == '*') F.offer(new int[]{i, j});

                }
            }

            int ans = bfs(S, F, board);
            if (ans == -1) sb.append("IMPOSSIBLE\n");
            else sb.append(ans+"\n");
        }

        bw.write(sb.toString());
        bw.close();
    }

    private static int bfs(Queue<int[]> J, Queue<int[]> F, char[][] board) {

        boolean[][] visit = new boolean[H][W];
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
                if(board[x][y] == '*') continue;
                if(x == 0 || x == H-1 || y == 0 || y == W-1) return cnt;

                for(int d = 0; d < 4; ++d){
                    nx = x + dx[d];
                    ny = y + dy[d];
                    if(nx >= 0 && nx < H && ny >= 0 && ny < W && board[nx][ny] == '.' && !visit[nx][ny]){
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
                    if(nx >= 0 && nx < H && ny >= 0 && ny < W && board[nx][ny] == '.'){
                        board[nx][ny] = '*';
                        F.offer(new int[]{nx, ny});
                    }
                }
            }

            ++cnt;
        }

        return -1;
    }
}
