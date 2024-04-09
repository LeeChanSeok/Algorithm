import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String str = br.readLine();
		
		char[] arr = new char[n+2];
		for(int i = 0; i < n; ++i) {
			arr[i+1] = str.charAt(i);
		}
		
		arr[0] = '0';
		arr[n+1] = arr[1];
		
		
		int s = 1, e = n + 1;
		int cnt = 0;
		while(s <= e) {
			
			while(s <= e && arr[s] == arr[s-1]) ++s;
			while(s <= e && arr[e] != arr[s]) --e;
			
			if(s > e) break;
			
			++cnt;
			++s;--e;
		}
		
		System.out.println(cnt);

	}

}