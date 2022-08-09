import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    public static int win;
    public static int lose;
     
    public static void playGame(int[] A, int[] BCard, int N) {
        int ASum = 0;
        int BSum = 0;
         
        for(int i = 0; i < N; i++) {
            if(A[i] > BCard[i]) ASum += A[i] + BCard[i];
            else if(A[i] < BCard[i]) BSum += A[i] + BCard[i];
        }
         
        if(ASum > BSum) win++;
        else if(ASum < BSum) lose++;
    }
     
    public static void perm(int[] A, int[] B, int[] BCard, boolean[] isUsed, int N, int cnt) {
        if(cnt == N) {
            playGame(A, BCard, N);
            return;
        }
         
        for(int i = 0;  i <N; i++ ) {
            if(!isUsed[i]) {
                isUsed[i] = true;
                BCard[cnt] = B[i];
                perm(A, B, BCard, isUsed, N, cnt+1);
                isUsed[i] = false;
                BCard[cnt] = 0;
            }
        }
    }
     
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
         
        int[] A,B, BCard;       
        int N = 9;
        boolean[] isUsed;
         
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            A = new int[N];
            B = new int[N];
            BCard = new int[N];
            isUsed = new boolean[2*N + 1];
            for(int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
                isUsed[A[i]] = true;
            }
             
            int i = 1;
            int cnt = 0;
            while (cnt < N) {
                if(!isUsed[i]) {
                    B[cnt++] = i;
                }
                i++;
            }
                     
            win = 0; lose = 0;
            isUsed = new boolean[N];
            perm(A, B, BCard, isUsed, N, 0);
            System.out.printf("#%d %d %d\n", tc, win, lose);
        }// test-case 종료
    }
}