import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int x, y, w, h;
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		int ans = Integer.MAX_VALUE;
		
		ans = Math.min(x, Math.abs(x-w));
		ans = Math.min(ans, y);
		ans = Math.min(ans, Math.abs(y-h));
		
		System.out.println(ans);
	}
}