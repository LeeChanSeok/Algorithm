import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; ++tc){
            st = new StringTokenizer(br.readLine());

            int aLen = Integer.parseInt(st.nextToken());
            int bLen = Integer.parseInt(st.nextToken());

            Set<String> aSet = new HashSet<>();

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < aLen; ++i) aSet.add(st.nextToken());

            int answer = 0;
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < bLen; ++i) {
                String str = st.nextToken();
                if(aSet.contains(str)) ++answer;
            }

            System.out.printf("#%d %d\n", tc, answer);
        }
    }
}
