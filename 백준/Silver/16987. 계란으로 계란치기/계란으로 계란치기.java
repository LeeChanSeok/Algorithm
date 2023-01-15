import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int ans = 0;
    static int[] weight;
    static int N;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        int[] eggs = new int[N];
        weight = new int[N];
        for(int i = 0; i < N; ++i){
            st = new StringTokenizer(br.readLine());

            eggs[i] = Integer.parseInt(st.nextToken());
            weight[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, eggs);
        System.out.println(ans);
    }

    private static void dfs(int idx, int[] eggs) {

        if(idx == N){
            int broken = 0;
            for(int i = 0; i < N; ++i) if(eggs[i] <= 0) ++broken;
            ans = Math.max(ans, broken);
            return;
        }

        if(eggs[idx] <= 0) dfs(idx + 1, eggs);
        else {
            boolean hit = false;
            for (int i = 0; i < N; ++i) {
                if(i == idx) continue;
                if(eggs[i] <= 0) continue;
                int[] new_eggs = new int[N];
                ArrayCopy(eggs, new_eggs);
                new_eggs[i] -= weight[idx];
                new_eggs[idx] -= weight[i];

                dfs(idx + 1, new_eggs);
                hit = true;
            }
            if(!hit) dfs(idx + 1, eggs);
        }
    }

    private static void ArrayCopy(int[] eggs, int[] newEggs) {
        for(int i = 0; i < N; ++i) newEggs[i] = eggs[i];
    }
}
