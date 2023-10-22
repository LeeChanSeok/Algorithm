import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int len = str.length();

        int ans = len;
        
        //1. 1로 바꾸기
        
        int res = 0;
        int i = 0; 
        int j = 0;
        while(i < len){
        	j = i;
            if(str.charAt(i) == '0'){

                res++;
                while(j < len && str.charAt(j) == '0'){
                    ++j;
                }
            }

            i = j + 1;
        }

        ans = Math.min(ans, res);
        //2. 0으로 바꾸기
        i = j = res = 0;
        while(i < len){
        	j = i;
            if(str.charAt(i) == '1'){

                res++;
                while(j < len && str.charAt(j) == '1'){
                    ++j;
                }
            }

            i = j + 1;
        }
        ans = Math.min(ans, res);

        System.out.println(ans);

	}

}