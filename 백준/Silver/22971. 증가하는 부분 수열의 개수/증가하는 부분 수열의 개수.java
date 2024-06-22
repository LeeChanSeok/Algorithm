import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final int MOD = 998244353;
    static int N;
    static int[] arr, D;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        D = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; ++i){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        LIS(N - 1);

        for(int num : D){
            sb.append(num + " ");
        }
        System.out.println(sb);
    }

    private static int LIS(int idx) {
        if(D[idx] != 0) return D[idx];

        int sum = 0;
        for (int j = idx - 1; j >= 0; --j){
            if(arr[j] < arr[idx]) sum = (sum + LIS(j)) % MOD;
            else LIS(j);
        }

        D[idx] = sum + 1;
        return D[idx];
    }
}