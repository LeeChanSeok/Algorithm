import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static int recursion(String s, int l, int r){
        ++cnt;
        if(l >= r) return 1;
        else if(s.charAt(l) != s.charAt(r)) return 0;
        else return recursion(s, l+1, r-1);
    }
    public static int isPalindrome(String s){
        return recursion(s, 0, s.length()-1);
    }

    static int cnt;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; ++i){
            String str = br.readLine();
            cnt = 0;
            int res = isPalindrome(str);

            System.out.println(res + " " + cnt);
        }
    }
}