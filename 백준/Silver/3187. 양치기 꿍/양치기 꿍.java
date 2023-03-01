import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};
    static int R, C, V, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        char[][] board = new char[R][C];
        for(int i = 0; i < R; ++i){
            board[i] = br.readLine().toCharArray();
        }

        boolean[][] visited = new boolean[R][C];
        for(int i = 0; i < R; ++i){
            for(int j = 0; j < C; ++j){
                if(visited[i][j] || board[i][j] == '#') continue;
                bfs(board, visited, i, j);
            }
        }

        System.out.println(K + " " + V);
    }

    private static void bfs(char[][] board, boolean[][] visited, int r, int c) {

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c});
        visited[r][c]=true;

        int v = 0, k = 0;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0]; int y = cur[1];
            if(board[x][y] == 'v') ++v;
            else if(board[x][y] == 'k') ++k;

            for(int d = 0; d < 4; ++d){
                int nx = x + dx[d];
                int ny = y + dy[d];

                if(nx < 0 || nx >= R || ny < 0 || ny >= C || visited[nx][ny] || board[nx][ny] == '#') continue;
                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny});
            }
        }

        if(k > v) K += k;
        else V += v;

    }

}
