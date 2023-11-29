import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		Map<String, Double> grade = new HashMap<>();
		grade.put("A+", 4.5);
		grade.put("A0", 4.0);
		grade.put("B+", 3.5);
		grade.put("B0", 3.0);
		grade.put("C+", 2.5);
		grade.put("C0", 2.0);
		grade.put("D+", 1.5);
		grade.put("D0", 1.0);
		grade.put("F", 0.0);
		
		
		double score = 0;
		double total = 0;
		double ans = 0;
		
		for(int i = 0; i < 20; ++i) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			
			double s = Double.parseDouble(st.nextToken());
			String g = st.nextToken();
			if(g.equals("P")) continue;
			
			total += s * grade.get(g);
			score += s;
		}
		
		System.out.printf("%.6f", total / score);

	}

}