
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static int[][] child;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; ++tc){
            st = new StringTokenizer(br.readLine());

            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            int[][] child = new int[V+1][2];
            int[] parent = new int[V+1];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < E; ++i){
                int f = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());

                if(child[f][0] == 0) child[f][0] = t;
                else child[f][1] = t;

                parent[t] = f;

            }

            List<Integer> A_pList = new ArrayList<>();
            List<Integer> B_pList = new ArrayList<>();

            find_parents(parent, A_pList, A);
            find_parents(parent, B_pList, B);

            int ASize = A_pList.size();
            int BSize = B_pList.size();

            int i = ASize-1, j = BSize-1;

            int comm = 0;
            while((A_pList.get(i).intValue() == B_pList.get(j).intValue()) && i >= 0 && j >= 0){
                comm = A_pList.get(i);
                --i; --j;
            }

            int cnt = bfs(child, comm);
            System.out.printf("#%d %d %d\n", tc, comm, cnt);

        }
    }

    private static int bfs(int[][] child, int comm) {
        int cnt = 1;

        Queue<Integer> q = new LinkedList<>();
        q.offer(comm);

        while(!q.isEmpty()){
            int node = q.poll();
            if(child[node][0] != 0) {
                q.offer(child[node][0]); ++cnt;
            }
            if(child[node][1] != 0){
                q.offer(child[node][1]); ++cnt;
            }
        }
        return cnt;
    }

    private static void find_parents(int[] parent, List<Integer> Plist, int num) {
        int node = num;

        while(node != 1){
            Plist.add(node);
            node = parent[node];
        }
        Plist.add(node);

    }

}
