import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; ++tc){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] dp = new int[K+1];

            for(int i = 0; i < N; ++i){
                st = new StringTokenizer(br.readLine());

                int V = Integer.parseInt(st.nextToken());
                int C = Integer.parseInt(st.nextToken());

                for(int j = K; j >= V; --j){
                    dp[j] = Math.max(dp[j], dp[j-V] + C);
                }
            }

            System.out.printf("#%d %d\n", tc, dp[K]);
        }
    }
}
