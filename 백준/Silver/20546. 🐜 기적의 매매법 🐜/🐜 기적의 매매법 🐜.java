import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static final int MAX_DAY = 14;
	static int[] stocks;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int price = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		stocks = new int[MAX_DAY+1];
		for(int i = 1; i <= MAX_DAY; ++i) stocks[i] = Integer.parseInt(st.nextToken());
		
		int bnp = BNP(price);
		int timing = TIMING(price);
		
		String answer;
		if(bnp == timing) answer = "SAMESAME";
		else if(bnp > timing) answer = "BNP";
		else answer = "TIMING";
		
		System.out.println(answer);
		
	}
	
	private static int TIMING(int price) {
	
		int stock = 0;
		int conti = 0;
		for(int i = 2; i <= MAX_DAY; ++i) {

			if(stocks[i] > stocks[i-1]) {
				if(conti >= 0) ++conti;
				else conti = 1;
			}else if(stocks[i] < stocks[i-1]) {
				if(conti <= 0) --conti;
				else conti = -1;
			}
			
			if(conti >= 3) {
				price += stocks[i] * stock;
				stock = 0;
			}else if(conti <= -3){
				stock += price / stocks[i];
				price = price % stocks[i];
				
			}
		}
		
		return stock * stocks[MAX_DAY] + price;
	}
	
	
	private static int BNP(int price) {

		int stock = 0;
		for(int i = 1; i <= MAX_DAY; ++i) {
			stock += price / stocks[i];
			price = price % stocks[i];
		}
		
		return stock * stocks[MAX_DAY] + price;
	}

}