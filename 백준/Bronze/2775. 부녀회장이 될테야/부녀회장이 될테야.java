import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        int N = 15;
        int[][] apartment = new int[N][N];

        init(apartment, N);

        int T = Integer.parseInt(br.readLine());
        int k, n, res;
        for(int tc = 1; tc <= T; ++tc){
            k = Integer.parseInt(br.readLine());
            n = Integer.parseInt(br.readLine());

            res = apartment[k][n];
            sb.append(res + "\n");
        }

        bw.write(sb.toString());
        bw.close();
        
    }

    private static void init(int[][] apartment, int N) {

        for(int j = 1; j < N; ++j){
            apartment[0][j] = j;
        }

        for(int i = 1; i < N; ++i){
            for(int j = 1; j < N; ++j){
                apartment[i][j] = apartment[i][j-1] + apartment[i-1][j];
            }
        }
    }
}