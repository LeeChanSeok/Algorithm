import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	static int[] number, floor;
	static char[][] tower;
	static int n;
	static List<Integer>[] list;
	
	public static void main(String[] args) throws Exception{
		init();
		input();

		pro();
	}

	

	private static void pro() {

		convert();
		if(!getCandidate()) {
			System.out.println(-1);
			return;
		}
		calc();
		
	}


	private static void calc() {

		long totalCnt = 1;
		for(int i = 0; i < n; ++i) {
			totalCnt *= list[i].size();
		}
		
		long totalSum = 0;
		for(int i = 0; i < n; ++i) {
			int digit_sum = 0;
			for(int num : list[i]) digit_sum += num;
			
			
			totalSum = totalSum * 10 + digit_sum * (totalCnt / list[i].size());
			
		}
		double ans = (double)totalSum / totalCnt;
		System.out.printf("%.5f", ans);
	}


	private static boolean getCandidate() {
		list = new List[n];
		for(int i = 0; i < n; ++i) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < n; ++i) {
			int num = floor[i];
			for(int j = 0; j < 10; ++j) {
				if((num & number[j]) == num) list[i].add(j);
			}
			if(list[i].size() == 0) return false;
		}
	
		return true;
	}



	private static void convert() {
		StringBuilder sb;
		
		for(int k = 0; k < n; ++k) {
			sb = new StringBuilder();
			for(int i = 0; i < 5; ++i) {
				for(int j = k*4; j < k*4 + 3; ++j) {
					if(tower[i][j] == '#') sb.append("1");
					else sb.append("0");
				}
			}
			floor[k] = Integer.parseInt(sb.toString(), 2);
		}
		
	}

	private static void input() throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		floor = new int[n];
		
		tower = new char[5][4*n - 1];
		for(int i = 0; i < 5; ++i) {
			tower[i] = br.readLine().toCharArray();
		}
		
		
		
	}
	
	private static void init() {
		number = new int[10];
		
		number[0] = Integer.parseInt("111101101101111", 2); // 0
		number[1] = Integer.parseInt("001001001001001", 2); // 1
		number[2] = Integer.parseInt("111001111100111", 2); // 2
		number[3] = Integer.parseInt("111001111001111", 2); // 3
		number[4] = Integer.parseInt("101101111001001", 2); // 4
		number[5] = Integer.parseInt("111100111001111", 2); // 5
		number[6] = Integer.parseInt("111100111101111", 2); // 6
		number[7] = Integer.parseInt("111001001001001", 2); // 7
		number[8] = Integer.parseInt("111101111101111", 2); // 8
		number[9] = Integer.parseInt("111101111001111", 2); // 9
		
	}

}