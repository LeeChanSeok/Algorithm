import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] weights = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; ++i) weights[i] = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < w; ++i) q.offer(0);
        int total_w = 0;
        int idx = 0;
        int time = 0;
        int truck;
        while(idx != n){
            total_w -= q.poll();

            truck = weights[idx];
            if(total_w + truck <= L) {
                q.offer(truck);
                total_w += truck;
                ++idx;
            }else{
                q.offer(0);
            }
            ++time;
        }
        time += w;

        System.out.println(time);
    }
}
