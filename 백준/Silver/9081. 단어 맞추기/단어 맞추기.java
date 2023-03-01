import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; ++i){
            char[] str = br.readLine().toCharArray();
            char[] next = nextPermutation(str, str.length);

            sb.append(String.valueOf(next)).append("\n");

        }
        bw.write(sb.toString());
        bw.close();
    }

    private static char[] nextPermutation(char[] str, int N) {

        int i = N -1;
        while(i > 0 && str[i] <= str[i-1]) --i;
        if(i == 0) return str;

        int j = N -1;
        while(j >= i && str[j] <= str[i-1]) --j;
        if(j < i) return str;

        swap(str, i-1, j);

        int k = N-1;
        while(i < k) swap(str, i++, k--);

        return str;
    }

    private static void swap(char[] str, int i, int j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }
}
