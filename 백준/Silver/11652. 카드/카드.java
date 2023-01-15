import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<Long, Long> numCnt = new HashMap<>();

        long num, cnt;
        long[] ans = {0, 0}; // num, cnt
        for(int i = 0; i < N; ++i){
            num = Long.parseLong(br.readLine());

            cnt = numCnt.getOrDefault(num, 0l) + 1;
            if(cnt > ans[1]) {
                ans = new long[]{num, cnt};
            }else if(cnt == ans[1] && num < ans[0]){
                ans = new long[]{num, cnt};
            }

            numCnt.put(num, cnt);
        }

        System.out.println(ans[0]);
    }
}