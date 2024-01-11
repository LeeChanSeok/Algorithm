import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Set<Integer> A = new HashSet<>();
		Set<Integer> B = new HashSet<>();

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; ++i) {
			A.add(Integer.parseInt(st.nextToken()));
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < m; ++i) {
			B.add(Integer.parseInt(st.nextToken()));
		}
		
		int ans = 0;
		int cnt = 0;
		
		for(int num : A) {
			if(B.contains(num)) ++cnt;
		}
		
		ans += A.size() - cnt;
		
		cnt = 0;
		for(int num : B) {
			if(A.contains(num)) ++cnt;
		}
		
		ans += B.size() - cnt;
		
		System.out.println(ans);
	}

}