import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();

        int orderSize = orders.length;
        int[] Iorders = new int[orderSize];
        for(int i = 0; i < orderSize; i++) {
            String order = orders[i];
            int temp = 0;
            for(int j = 0, size = order.length(); j < size; j++) {
                char c = order.charAt(j);
                temp |= 1 << (c - 'A');
            }
            Iorders[i] = temp;
        }

        int[] maxCnt = new int[11];
        List<Integer>[] menu = new ArrayList[11];
        for(int i = 0; i < 11; i++)
            menu[i] = new ArrayList<>();


        for(int flag = 3, size = 1 << ('Z' - 'A' + 1); flag < size; flag++) {
            int count = subsetCount(flag);
            if(count < 2 || count > 10 || !isCourse(count, course)) continue;

            int cnt = 0;
            for(int i = 0; i < orderSize; i++) {
                if((Iorders[i] & flag) == flag) cnt++;
            }
            if(cnt >= maxCnt[count]) {
                if(cnt > maxCnt[count]) {
                    maxCnt[count] = cnt;
                    menu[count].clear();
                }
                menu[count].add(flag);
            }

        }
        StringBuilder sb;
        int size = 'Z' - 'A' + 1;
        for(int num : course) {

            if(maxCnt[num] < 2) continue;
            for(int cs : menu[num]) {
                sb = new StringBuilder();
                for(int i = 0; i < size; i++) {
                    if((cs & 1 << i) != 0) sb.append((char)('A' + i));
                }
                answer.add(sb.toString());
            }
        }
        Collections.sort(answer);
        return  answer.toArray(new String[answer.size()]);
    }

    private static boolean isCourse(int count, int[] course) {
        for(int num : course)
            if(num == count) return true;
        return false;
    }

    private static int subsetCount(int flag) {
        int cnt = 0;
        int size = 'Z' - 'A' + 1;
        for(int i = 0; i < size; i++) {
            if((flag & 1 << i) !=  0) cnt++;
            if(cnt > 10) break;
        }
        return cnt;
    }
}