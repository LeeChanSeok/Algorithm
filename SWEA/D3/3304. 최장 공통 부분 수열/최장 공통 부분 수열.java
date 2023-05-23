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

            char[] charArr1 = st.nextToken().toCharArray();
            char[] charArr2 = st.nextToken().toCharArray();

            int N1 = charArr1.length;
            int N2 = charArr2.length;

            int[][] dp = new int[N1+1][N2+1];
            for(int i = 1; i <= N1; ++i){
                for(int j = 1; j <= N2; ++j){

                    if(charArr1[i-1] == charArr2[j-1]){
                        dp[i][j] = dp[i-1][j-1] + 1;
                    }else{
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                    }

                }
            }

            System.out.printf("#%d %d\n", tc, dp[N1][N2]);

        }

    }
}
