import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N;
        int x, y;
        int[] S, E;
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc<=T; ++tc){
            N = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            S = new int[]{x, y};

            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            E = new int[]{x, y};

            sb.append(bfs(N, S, E)).append("\n");
        }
        bw.write(sb.toString());
        bw.close();
    }

    private static int bfs(int N, int[] S, int[] E) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(S);
        boolean[][] visit = new boolean[N][N];
        visit[S[0]][S[1]] = true;

        int cnt = 0;
        int qSize;
        int x, y, nx, ny;
        int[] cur;
        while(!q.isEmpty()){
            qSize = q.size();
            while(qSize-- > 0){
                cur = q.poll();
                x = cur[0]; y = cur[1];

                if(x == E[0] && y == E[1]) return cnt;

                for(int d = 0; d < 8; ++d){
                    nx = x + dx[d];
                    ny = y + dy[d];
                    if(nx < 0 || nx >= N || ny < 0 || ny >= N || visit[nx][ny]) continue;

                    visit[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }
            cnt++;
        }

        return 0;
    }
}
