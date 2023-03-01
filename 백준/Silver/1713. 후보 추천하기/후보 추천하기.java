import java.io.*;
import java.util.*;

public class Main {

    static class Recommend{
        int stuID;
        int regTime;
        int recCnt;

        public Recommend(int stuID, int regTime, int recCnt){
            this.stuID =stuID;
            this.regTime = regTime;
            this.recCnt = recCnt;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] students = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; ++i) students[i] = Integer.parseInt(st.nextToken());

        int pictureCnt = 0;
        int time = 1;

        PriorityQueue<Recommend> pq = new PriorityQueue<>( (p1, p2) -> {
            if(p1.recCnt == p2.recCnt) return p1.regTime - p2.regTime;
            return p1.recCnt - p2.recCnt;
        });

        Map<Integer, Recommend> recommendMap = new HashMap<>();
        for(int i = 0; i < M; ++i){
            int stuID = students[i];

            if(recommendMap.containsKey(stuID)){
                Recommend recommend = recommendMap.get(stuID);
                Recommend newRecommend = new Recommend(stuID, recommend.regTime, recommend.recCnt + 1);
                recommend.stuID = -1;

                pq.offer(newRecommend);
                recommendMap.put(stuID, newRecommend);

            }else{
                Recommend recommend = new Recommend(stuID, time, 1);
                if(pictureCnt < N){
                    ++pictureCnt;
                }else{
                    Recommend old;
                    while((old = pq.poll()).stuID == -1) {};
                    recommendMap.remove(old.stuID);
                    old.stuID = -1;
                }
                pq.offer(recommend);
                recommendMap.put(stuID, recommend);
            }
            ++time;
        }

        List<Integer> list = new LinkedList<>();
        for(int i = 0; i < pictureCnt; ++i){
            Recommend recommend;
            while((recommend = pq.poll()).stuID == -1) {};
            list.add(recommend.stuID);
        }

        Collections.sort(list);
        for(int num : list) sb.append(num).append(" ");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
