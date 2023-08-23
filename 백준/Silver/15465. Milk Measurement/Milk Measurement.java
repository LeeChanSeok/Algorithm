import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static class Data{
		int day;
		int name;
		int num;
		
		public Data(int day, int name, int num) {
			super();
			this.day = day;
			this.name = name;
			this.num = num;
		}
		
	}
	
	static int n;
	static int[] num;
	static Data[] datas;
	
	public static void main(String[] args) throws Exception {
		input();
		pro();
	}

	private static void pro() {
		
		Arrays.sort(datas, (d1, d2) -> d1.day - d2.day);
		
		int ans = 0;
		int prev = (1 << 3) - 1;
		for(Data data : datas) {
			num[data.name] += data.num;
			
			int maxValue = findMaxValue();
			int picture = getPicture(maxValue);

			if(picture != prev) ++ans;
			prev = picture;
		}
		
		System.out.println(ans);
		
	}

	private static int getPicture(int maxValue) {

		int flag = 0;
		for(int i = 0; i < 3; ++i) {
			if(num[i] == maxValue) flag |= (1 << i);
		}
		return flag;
	}

	private static int findMaxValue() {

		int res = num[0];
		for(int i = 1; i < 3; ++i) {
			if(num[i] > res) res = num[i];
		}
		return res;
	}

	private static void input() throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		
		datas = new Data[n];
		for(int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			
			int day = Integer.parseInt(st.nextToken());
			
			String name = st.nextToken();
			int idx = 0;
			if(name.charAt(0) == 'B') idx = 0;
			else if(name.charAt(0) == 'E') idx = 1;
			else if(name.charAt(0) == 'M') idx = 2;
			
			int num = Integer.parseInt(st.nextToken());
			
			datas[i] = new Data(day, idx, num);
		}
		
		num = new int[3];
		Arrays.fill(num, 7);
		
	}

}