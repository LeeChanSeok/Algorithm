import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        PriorityQueue<Integer> R = new PriorityQueue<>();
        PriorityQueue<Integer> L = new PriorityQueue<>((p1, p2) -> p2 - p1);

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; ++tc){
            int answer = 0;
            L.clear();
            R.clear();
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken());

            L.offer(A);

            for(int i = 0; i < N; ++i){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < 2; ++j){
                    int num =  Integer.parseInt(st.nextToken());

                    if(num <= L.peek()) L.offer(num);
                    else R.offer(num);

                    if(L.size() > R.size()+1) R.offer(L.poll());
                    else if(R.size() > L.size()) L.offer(R.poll());
                }
                answer = (answer + L.peek()) % 20171109;
            }
            System.out.printf("#%d %d\n",tc ,answer);
        }
    }
}
