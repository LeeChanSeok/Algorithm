import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        final int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
        final int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

        int N = Integer.parseInt(br.readLine());

        char[][] mine = new char[N][N];
        for(int i = 0; i < N; ++i) mine[i] = br.readLine().toCharArray();

        char[][] board = new char[N][N];
        boolean pushmine = false;
        for(int i = 0; i < N; ++i){
            char[] line = br.readLine().toCharArray();
            for(int j = 0; j < N; ++j){
                if(line[j] == 'x') {
                    if(mine[i][j] == '*') pushmine = true;
                    int cnt = 0;
                    for (int d = 0; d < 8; ++d) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];

                        if (nx >= 0 && nx < N && ny >= 0 && ny < N && mine[nx][ny] == '*') {
                            ++cnt;
                        }
                    }
                    board[i][j] = (char)(cnt + '0');
                }else board[i][j] = '.';

            }

        }

        for(int i = 0; i < N; ++i){
            for(int j = 0; j < N; ++j){
                if(pushmine && mine[i][j] == '*') {
                    board[i][j] = '*';
                }
                sb.append(board[i][j]);
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.close();
    }
}
