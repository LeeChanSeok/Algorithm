import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		Integer[] numbers = new Integer[N];
		for(int i = 0; i < N; ++i) numbers[i] = Integer.parseInt(br.readLine());
		
		Arrays.sort(numbers);
		for(Integer num : numbers) sb.append(num + "\n");
		
		bw.write(sb.toString());
		bw.flush();
		
		bw.close();
		br.close();

	}

}