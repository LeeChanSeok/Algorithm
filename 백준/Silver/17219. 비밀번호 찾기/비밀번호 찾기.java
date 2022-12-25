import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Map<String, String> password = new HashMap<>(N);

		String url, pass;
		for(int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			url = st.nextToken();
			pass = st.nextToken();
			password.put(url, pass);
		}
		
		for(int i = 0; i < M; ++i) {
			sb.append(password.get(br.readLine())+"\n");
		}
		
		bw.write(sb.toString());
		bw.close();
	}

}