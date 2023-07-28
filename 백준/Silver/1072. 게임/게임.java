import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int x, y, z;
	
	public static void main(String[] args) throws Exception{
		input();
		pro();
	}

	private static void pro() {

		int ans = -1;
		int z = getPercent(x, y);
		int l = 0, r = (int)1e9;
		
		while(l <= r) {
			int mid = (l + r) / 2;
			
			if(getPercent(x + mid, y + mid) != z) {
				ans = mid;
				r = mid - 1;
			}else {
				l = mid + 1;
			}
		}
		
		System.out.println(ans);
		
	}

	private static int getPercent(int x, int y) {
		return (int)((long) y * 100/x);
	}

	private static void input() throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());

		
	}

}