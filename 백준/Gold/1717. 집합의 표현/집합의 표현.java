import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n, m;
	static int[] parents;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		parents = new int[n+1];
		for(int i = 0; i <= n; ++i) parents[i] = i;
		
		for(int i = 0; i < m; ++i) {
			st = new StringTokenizer(br.readLine());
			
			int c = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(c == 0) {
				union(a, b);
			}else {
				if(getParent(a) == getParent(b)) sb.append("YES\n");
				else sb.append("NO\n");
			}
			
		}

		System.out.println(sb);
	}

	private static void union(int a, int b) {

		int x = getParent(a);
		int y = getParent(b);
		
		parents[y] = x;
		
	}

	private static int getParent(int a) {
		
		if(a == parents[a]) return a;
		else parents[a] = getParent(parents[a]);
		
		return parents[a];
	}

}