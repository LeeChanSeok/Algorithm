import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder(); 
		
		int k = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
	
		char[] up = new char[k];
		for(int i = 0; i < k; ++i) up[i] = (char)('A' + i);
		char[] down = br.readLine().toCharArray();
		
		char[][] ladder = new char[n][k-1];
		for(int i = 0; i < n; ++i) ladder[i] = br.readLine().toCharArray();
		
		int hide = 0;
		for(int i = 0; i < n; ++i) {
			if(ladder[i][0] == '?') {
				hide = i;
				break;
			}
		}
		
		char[][] res = new char[2][k];
		// down
		for(int i = 0; i < k; ++i) {
			int x = i;
			for(int y = 0; y < hide; ++y) {
				if(x != k-1 && ladder[y][x] == '-') ++x;
				else if(x != 0 && ladder[y][x-1] == '-') --x;
				
			}
			res[0][x] = (char)('A' + i);
		}
		
		//up
		for(int i = 0; i < k; ++i) {
			int x = i;
			for(int y = n-1; y > hide; --y) {
				if(x != k-1 && ladder[y][x] == '-') ++x;
				else if(x != 0 && ladder[y][x-1] == '-') --x;
			}
			
			res[1][x] = down[i];
		}
				
		int i;
		for(i = 0; i < k; ++i) {
			
			if(res[0][i] == res[1][i]) sb.append("*");
			else if(res[0][i] == res[1][i+1] && res[0][i+1] == res[1][i]) {
				sb.append("-*");
				++i;
			}else break;
		}
		
		if(sb.length() == k) sb.deleteCharAt(k-1);
		
		if(i != k) {
			sb = new StringBuilder();
			for(int j = 0; j < k-1; ++j) sb.append("x");
		}
		
		bw.write(sb.toString());
		bw.flush();
		
		bw.close();
		br.close();
		
	}

}
