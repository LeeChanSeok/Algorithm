import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static List<int[]> list;
    static int N, M;
    static int[] arr, pick;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; ++i) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);

        pick = new int[M];
        list = new ArrayList<>();
        combination(0, 0);

        for(int[] temp : list){
            for(int i : temp) System.out.print(i + " ");
            System.out.println();
        }
    }

    private static void combination(int idx, int cnt) {
        if(cnt == M){
            if(!isDuplicate())list.add(Arrays.copyOfRange(pick, 0, M));
            return;
        }

        for(int i = idx; i < N; ++i){
            pick[cnt] = arr[i];
            combination(i, cnt + 1);
        }
    }

    private static boolean isDuplicate() {

        for(int[] temp : list){
            int i = 0;
            for(; i < M; ++i){
                if(temp[i] != pick[i]) break;
            }
            if(i == M) return true;
        }
        return false;
    }

}