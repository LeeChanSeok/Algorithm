
import java.io.*;
import java.util.*;

public class Main {
    static final int DELTA1 = 1000000;
    static final int DELTA2 = 1000;
    static int A, B, C;
    static Set<Integer> set;
    static List<Integer> answer;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        set = new HashSet<>();
        answer = new LinkedList<>();
        dfs(0, 0, C);
        Collections.sort(answer);

        for(int n : answer) sb.append(n).append(" ");
        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();

    }

    private static void dfs(int a, int b, int c) {
        int res = a * DELTA1 + b * DELTA2 + c;
        if(set.contains(res)) return;
        set.add(res);

        if(a == 0) answer.add(c);

        // a -> b
        if(a + b > B) dfs(a - (B - b), B, c);
        else dfs(0, a + b, c);

        // a -> c
        if(a + c > C) dfs(a - (C - c), b, C);
        else dfs(0, b, a + c);

        // b -> a
        if(a + b > A) dfs(A, b - (A - a), c);
        else dfs(a + b, 0, c);

        // b -> c
        if(c + b > C) dfs(a, b - (C - c), C);
        else dfs(a, 0, b + c);

        // c -> a
        if(a + c > A) dfs(A, b, c - (A - a));
        else dfs(a + c, b, 0);

        // c -> b
        if(b + c > B) dfs(a, B, c - (B - b));
        else dfs(a, b + c, 0);

    }
}
