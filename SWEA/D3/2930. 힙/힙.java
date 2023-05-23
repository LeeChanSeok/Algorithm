import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; ++tc){
            sb = new StringBuilder();
            int N = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> pq = new PriorityQueue<>((p1, p2) -> p2-p1);

            for(int i = 0; i < N; ++i){
                st = new StringTokenizer(br.readLine());
                if(st.nextToken().charAt(0) == '1'){
                    pq.offer(Integer.parseInt(st.nextToken()));
                }else{
                    int num = -1;
                    if(!pq.isEmpty()) num = pq.poll();
                    sb.append(num + " ");
                }
            }

            System.out.printf("#%d %s\n", tc, sb.toString());
        }
    }

}
