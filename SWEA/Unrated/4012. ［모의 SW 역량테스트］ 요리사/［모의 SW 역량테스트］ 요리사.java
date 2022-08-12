import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
 
        int T = Integer.parseInt(br.readLine());
        int N, combCnt, combTotal, min;
        int[][] Synergy, memoiz;
        int[] comb;
        for (int tc = 1; tc <= T; tc++) {
            // if (tc != 1) break;
            N = Integer.parseInt(br.readLine());
            Synergy = new int[N][N];
            memoiz = new int[N + 1][N / 2 + 1];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++)
                    Synergy[i][j] = Integer.parseInt(st.nextToken());
            }
 
            comb = new int[N];
            for (int i = N - 1; i >= N / 2; i--)
                comb[i] = 1;
            combTotal = combinationCount(memoiz, N, N / 2);
            combCnt = 0;
            min = Integer.MAX_VALUE;
            do {
                min = Math.min(min, Solution(comb, Synergy));
            } while (++combCnt < combTotal / 2 && nextCombination(comb));
            System.out.printf("#%d %d\n", tc, min);
        }
    }
 
    public static int Solution(int[] combA, int[][] Synergy) {
        int N = combA.length;
        int[] combB = new int[N];
        for (int i = 0; i < N; i++)
            if (combA[i] == 0)
                combB[i] = 1;
 
        int scoreA = 0;
        for (int i = 0; i < N - 1; i++) {
            if (combA[i] == 0)
                continue;
            for (int j = i + 1; j < N; j++) {
                if (combA[j] == 1) {
                    scoreA += Synergy[i][j];
                    scoreA += Synergy[j][i];
                }
 
            }
        }
        int scoreB = 0;
        for (int i = 0; i < N - 1; i++) {
            if (combB[i] == 0)
                continue;
            for (int j = i + 1; j < N; j++) {
                if (combB[j] == 1) {
                    scoreB += Synergy[i][j];
                    scoreB += Synergy[j][i];
                }
            }
        }
        return Math.abs(scoreA - scoreB);
    }
 
    public static int combinationCount(int[][] memoiz, int n, int r) {
 
        if (r > n / 2)
            r = n - r;
        if (memoiz[n][r] != 0)
            return memoiz[n][r];
        if (r == 1) {
            memoiz[n][r] = n;
            return n;
        } else if (r == 0) {
            memoiz[n][r] = 0;
            return 0;
        }
 
        memoiz[n][r] = combinationCount(memoiz, n - 1, r - 1) + combinationCount(memoiz, n - 1, r);
        return memoiz[n][r];
    }
 
    public static boolean nextCombination(int[] comb) {
        int N = comb.length;
        int i = N - 1;
        while (i > 0 && comb[i - 1] >= comb[i])
            i--;
 
        if (i == 0)
            return false;
 
        int j = N - 1;
        while (comb[i - 1] >= comb[j])
            j--;
        swap(comb, i - 1, j);
 
        int k = N - 1;
        while (i < k) {
            swap(comb, i, k);
            i++;
            k--;
        }
 
        return true;
 
    }
 
    public static void swap(int[] comb, int i, int j) {
        int temp = comb[i];
        comb[i] = comb[j];
        comb[j] = temp;
    }
}