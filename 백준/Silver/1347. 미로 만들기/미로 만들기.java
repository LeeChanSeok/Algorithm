import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    static int n;
    static int delta = 1000;
    static char[] command;
    static Set<Integer> point;

    public static void main(String[] args) throws Exception {

        input();
        pro();
    }

    private static void pro() {

        int[][] conner = new int[2][2];
        conner[0][0] = conner[0][1] = conner[1][0] = conner[1][1] = 100;

        int dir = 2;
        int x = 100;
        int y = 100;

        point = new HashSet<>();
        point.add(x * delta + y);

        for (int i = 0; i < n; ++i) {
            char comm = command[i];
            if(comm == 'F') {
                x += dx[dir];
                y += dy[dir];

                point.add(x * delta + y);
                conner[0][0] = Math.min(x, conner[0][0]);
                conner[0][1] = Math.min(y, conner[0][1]);
                conner[1][0] = Math.max(x, conner[1][0]);
                conner[1][1] = Math.max(y, conner[1][1]);

            }else if(comm == 'R'){
                dir = (dir + 1) % 4;
            }else if(comm == 'L'){
                dir = (dir + 3) % 4;
            }
        }

        int r = conner[1][0] - conner[0][0] + 1;
        int c = conner[1][1] - conner[0][1] + 1;

        char[][] board = new char[r][c];
        for(int i = 0; i < r; ++i) {
            Arrays.fill(board[i], '#');
        }

        for(int cord : point) {
            x = cord / delta - conner[0][0];
            y = cord % delta - conner[0][1];

            board[x][y] = '.';

        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < r; ++i) {
            for(int j = 0; j < c; ++j) {
                sb.append(board[i][j]);
            }
            sb.append('\n');
        }

        System.out.println(sb);

    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        command = br.readLine().toCharArray();

    }
}