import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
		public boolean isPrime(long n) {
			
			if(n == 1) return false;
			if(n == 2) return true;
			
			for(int i = 2; i < Math.sqrt(n)+1; i++) {
				if(n % i == 0) return false;
			}
			
			return true;
		}
		
	    public int solution(int n, int k) {
	        int answer = 0;
	        
	        List<Character> num = new ArrayList<>();
	        while(n != 0) {
	        	num.add((char)(n%k + '0'));
	        	n/=k;
	        }
	        Collections.reverse(num);
	        num.add('0');
	        char c;
	        String temp = "";
	        for(int i = 0, size = num.size(); i < size; i++) {
	        	c = num.get(i);
	        	if(c != '0') temp += Character.toString(c);
	        	else if(c=='0' && !temp.equals("")) {
	        		if(isPrime(Long.parseLong(temp))) answer++;
	        		temp = "";
	        	}
	        }
	        
	        return answer;
	    }
}