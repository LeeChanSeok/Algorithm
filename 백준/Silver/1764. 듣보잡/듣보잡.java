import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		String[] notHear = new String[N];
		String[] notSee = new String[M];
		
		
		for(int i = 0; i < N; i++)
			notHear[i] = br.readLine();
		
		for(int i = 0; i < M; i++)
			notSee[i] = br.readLine();

		Arrays.sort(notHear);
		Arrays.sort(notSee);
		
		int h = 0;
		int s = 0;
		int ans = 0;
		while(h < N && s < M) {
			int compare = notHear[h].compareTo(notSee[s]);
			if(compare == 0) {
				sb.append(notHear[h]+"\n");
				h++; s++;ans++;
			}else if(compare < 0) h++;
			else s++;
		}

		System.out.println(ans);
		bw.write(sb.toString());
		bw.close();
		
	}

}
