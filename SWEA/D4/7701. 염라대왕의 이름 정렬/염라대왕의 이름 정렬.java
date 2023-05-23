import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        Map<Integer, Set<String>> map;

        for(int tc = 1; tc <= T; ++tc){

            map = new HashMap<>();

            for(int i = 1; i <= 50; ++i){
                map.put(i, new HashSet<>());
            }

            int N = Integer.parseInt(br.readLine());

            for(int i = 0; i < N; ++i){
                String str = br.readLine();
                map.get(str.length()).add(str);
            }
            sb.append("#" + tc + " \n");
            for(int i = 1; i <= 50; ++i){
                Set<String> set = map.get(i);
                List<String> list = new ArrayList<>(set);
                Collections.sort(list, (l1, l2) -> l1.compareTo(l2));

                for(String s : list) {
                    sb.append(s + "\n");
                }
            }

        }
        bw.write(sb.toString());
        bw.close();
    }
}
