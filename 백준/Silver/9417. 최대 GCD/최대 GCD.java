import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static int size;


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        arr = new int[100];

        while(T-- > 0){
            st = new StringTokenizer(br.readLine());
            size = 0;
            while(st.hasMoreTokens()){
                arr[size++] = Integer.parseInt(st.nextToken());
            }

            int max = 0;
            for(int i = 0; i < size - 1; ++i){
                for(int j = i + 1; j < size; ++j){
                    max = Math.max(max, GCD(arr[i], arr[j]));
                }
            }
            sb.append(max).append('\n');
        }

        System.out.println(sb);
    }

    private static int GCD(int a, int b) {
        if(a > b){
            int tmp = a;
            a = b;
            b = tmp;
        }

        while(b != 0){
            int n = a % b;
            a = b;
            b = n;
        }

        return a;
    }
}