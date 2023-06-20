import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] car_num = br.readLine().toCharArray();
		
		int answer = (car_num[0] == 'c') ? 26 : 10;
		for(int i = 1, len = car_num.length; i < len; ++i) {
			if(car_num[i] == car_num[i-1]) answer *= (car_num[i] == 'c') ? 25 : 9;
			else answer *= (car_num[i] == 'c') ? 26 : 10;
		}
		
		System.out.println(answer);

	}

}