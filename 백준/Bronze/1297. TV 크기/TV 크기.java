import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int d = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		
		double res = Math.sqrt(1.0*(d*d) / ((w*w) + (h*h)));
		
		
		System.out.println((int)(res * h) + " " + (int)(res * w));
	}

}