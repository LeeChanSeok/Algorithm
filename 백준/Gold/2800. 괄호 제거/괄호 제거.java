import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int delta = 200;

    static char[] arr;
    static List<Integer> candi;
    static Set<String> res;
    static int len, size;
    static boolean[] isUsed;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = br.readLine().toCharArray();
        len = arr.length;

        candi = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for(int i = 0 ; i < len; ++i){
            if(arr[i] == '(') stack.add(i);
            else if(arr[i] == ')') candi.add(stack.pop() * delta + i);
        }

        size = candi.size();
        isUsed = new boolean[len];
        res = new TreeSet<>();
        combi(0);

        for(String s : res){
            System.out.println(s);
        }
    }

    private static void combi(int idx) {

        if(idx == size){
            StringBuilder sb = new StringBuilder();

            for(int i = 0; i < len; ++i){
                if(!isUsed[i]) sb.append(arr[i]);
            }

            if(sb.length() != len){
                res.add(sb.toString());
            }

            return;
        }

        int pos = candi.get(idx);
        int l = pos / delta;
        int r = pos % delta;

        isUsed[l] = isUsed[r] = true;
        combi(idx + 1);
        isUsed[l] = isUsed[r] = false;
        combi(idx + 1);

    }


}