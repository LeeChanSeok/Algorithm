import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
				
		int N = Integer.parseInt(br.readLine());
		
		int[] num = new int[10001];
		for(int i = 0; i < N; ++i) 
			++num[Integer.parseInt(br.readLine())];
		
		
		for(int i = 1; i <= 10000; ++i) 
			for(int j = 0, cnt = num[i]; j < cnt; ++j)
				bw.write(i + "\n");
			
		bw.close();
	}

}