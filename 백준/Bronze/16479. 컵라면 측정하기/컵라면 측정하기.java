import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int K = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		int D1 = Integer.parseInt(st.nextToken());
		int D2 = Integer.parseInt(st.nextToken());
		double cha = (D1 - D2)/2.;
		
		double res = K * K - cha * cha;
		
		System.out.println(res);

	}

}