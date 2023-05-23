import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        for(int i = n; ; i++) {
            if(isPalindrome(i) && isPrime(i)) {
                System.out.println(i);
                break;
            }
        }   
	}

    public static boolean isPalindrome(int n) {
        String num = Integer.toString(n);
        for(int i = 0; i <= num.length() / 2; i++) {
            if(num.charAt(i) != num.charAt(num.length() - i - 1)) return false;
        }
        return true;
    }
    
    public static boolean isPrime(int n) {
        if(n == 1) return false;
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) return false;
        }
        return true;
    }
    
}