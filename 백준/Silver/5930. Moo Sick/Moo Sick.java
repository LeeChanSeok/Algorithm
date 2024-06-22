import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, C;
    static int[] arr, arr2;
    static List<Integer> list, ans;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        for(int i = 0; i < N; ++i){
            arr[i] = Integer.parseInt(br.readLine());
        }

        C = Integer.parseInt(br.readLine());
        arr2 = new int[C];
        int min = 100;
        for(int i = 0; i < C; ++i){
            arr2[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr2);

        if(C > N){
            System.out.println('0');
        } else {
            list = new ArrayList<>();
            for(int i = 0; i < C; ++i) {
                list.add(arr[i]);
            }
            Collections.sort(list);
            ans = new LinkedList<>();

            int idx = 0;
            while(true){
                // 1. check;
                if(isSame()) ans.add(idx + 1);

                // 2. 다음 진행 여부
                if(idx + C >= N) break;

                // 3. in, out, sort
                InOut(idx);
                Collections.sort(list);

                ++idx;
            }

            System.out.println(ans.size());
            for(int res : ans){
                System.out.println(res);
            }
        }

    }

    private static void InOut(int idx) {
        int in = arr[idx + C];
        int out = arr[idx];

        list.add(in);
        for(int i = 0; i < C; ++i){
            if(list.get(i) == out){
                list.remove(i);
                break;
            }
        }

    }

    private static boolean isSame() {
        int diff = list.get(0) - arr2[0];
        for(int i = 1; i < C; ++i){
            if(list.get(i) - arr2[i] != diff) return false;
        }

        return true;
    }

}