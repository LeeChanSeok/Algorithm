import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int paper;
    static int answer;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static char[][] maze;
    static boolean[][] visit;
    static int H, W, keys;
    static Map<Character, List<int[]>> find_door;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; ++tc){
            st = new StringTokenizer(br.readLine());

            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            maze = new char[H][W];
            paper = 0;
            for(int i = 0; i < H; ++i){
                maze[i] = br.readLine().toCharArray();
                for(int j = 0; j < W; ++j){
                    if(maze[i][j] == '$') ++paper;
                }
            }

            if(paper == 0) {
                System.out.println(0);
                br.readLine();
                continue;
            }

            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            keys = 0;
            if(str.charAt(0) != '0'){
                for(int i = 0; i < str.length(); ++i)
                    keys |= ( 1 << (int)(str.charAt(i) - 'a'));
            }

            visit = new boolean[H][W];
            find_door = new HashMap<>();
            answer = 0;
            char c;

            // 반복 조건 추가하기
            boolean find_paper = true;
            while(find_paper) {
                find_paper = false;
                for (int i = 0; i < H; ++i) {
                    for (int j = 0; j < W; ++j) {
                        if ((i == 0 || i == H - 1 || j == 0 || j == W - 1)
                                && !visit[i][j]
                                && maze[i][j] != '*') {

                            // 탐색 조건
                            c = maze[i][j];
                            if(c == '.'
                                || c == '$'
                                || (c >= 'a' && c <='z')
                                || (c >= 'A' && c <= 'Z' && ((keys & 1 <<(int)(c - 'A')) != 0))
                            ) {
                                bfs(i, j);
                                find_paper = true;
                            }

                        }
                        if (answer == paper) break;
                    }
                    if (answer == paper) break;
                }
            }
            System.out.println(answer);

        }

    }

    private static void bfs(int i, int j) {

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});
        visit[i][j] = true;


        char c, door;
        int x, y, nx, ny;
        int[] cur;

        c = maze[i][j];
        if(c == '$') ++answer;
        else if (c >= 'a' && c <= 'z') keys |= (1 << (int)(c - 'a'));

        while(!q.isEmpty()){
            cur = q.poll();
            x = cur[0]; y = cur[1];
            for(int d = 0; d < 4; ++d){
                nx = x + dx[d];
                ny = y + dy[d];
                if(nx < 0 || nx >= H || ny < 0 || ny >= W
                        ||maze[nx][ny] == '*'
                        || visit[nx][ny]) continue;

                c = maze[nx][ny];

                // key
                if(c >= 'a' && c <= 'z'){
                    keys |= ( 1 << (int)(c - 'a'));
                    q.offer(new int[]{nx, ny});
                    visit[nx][ny] = true;

                    door = (char)(c - 'a' + 'A');
                    if(find_door.containsKey(door)){
                        for(int[] pos : find_door.get(door)){
                            q.offer(pos);
                            visit[pos[0]][pos[1]] = true;
                        }
                        find_door.remove(door);
                    }

                }
                // door
                else if(c >= 'A' && c <= 'Z'){
                    int key = (int)(c - 'A');
                    if((keys & (1 << key)) != 0){
                        q.offer(new int[]{nx, ny});
                        visit[nx][ny] = true;
                    }else{
                        if(!find_door.containsKey(c)) find_door.put(c, new LinkedList<int[]>());
                        find_door.get(c).add(new int[]{nx, ny});
                    }

                }
                // & , .
                else{
                    q.offer(new int[]{nx, ny});
                    visit[nx][ny] = true;
                    if(maze[nx][ny] == '$') ++answer;
                }

            }

            if(answer == paper) return;
        }

    }
}