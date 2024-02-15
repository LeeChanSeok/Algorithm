import java.util.Scanner;

public class Main {
	    
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        String str = sc.nextLine();
	        
	        int len = str.length();
	        int[] cnt = new int[10];
	        long total = 0;
	        for(int i = 0; i < len; i++) {
	            int digit = str.charAt(i) - '0';
	            cnt[digit] += 1;
	            total += digit;
	        }
	        
	        if(cnt[0] == 0 || total % 3 != 0) {
	            System.out.println("-1");
	            return;
	        }
	        
	        StringBuilder sb = new StringBuilder();
	        for(int i = 9; i >= 0; i--) {
	            while(cnt[i] > 0) {
	                sb.append(i);
	                cnt[i]--;
	            }
	        }
	        System.out.println(sb.toString());
	    }
}