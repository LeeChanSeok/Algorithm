import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		int l = (int)(Math.sqrt(w*w + h*h));
		
		for(int i = 0; i < n; ++i) {
			int k = Integer.parseInt(br.readLine());
			if(k <= l) sb.append("DA\n");
			else sb.append("NE\n");
		}
		
		System.out.println(sb);
	}

}