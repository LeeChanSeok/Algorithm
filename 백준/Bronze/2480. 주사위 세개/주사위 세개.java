import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int dice1 = Integer.parseInt(st.nextToken());
		int dice2 = Integer.parseInt(st.nextToken());
		int dice3 = Integer.parseInt(st.nextToken());
		
		int ans = 0;
		if(dice1 == dice2 && dice2 == dice3) ans = 10000 + dice1 * 1000;
		else if(dice1 == dice2) ans = 1000 + dice1 * 100;
		else if(dice1 == dice3) ans = 1000 + dice1 * 100;
		else if(dice2 == dice3) ans = 1000 + dice2 * 100;
		else {
			ans = Math.max(Math.max(dice1, dice2), dice3) * 100;
		}

		System.out.println(ans);
	}

}