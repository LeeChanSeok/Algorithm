import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; ++i) {
			int G = Integer.parseInt(st.nextToken());
			int P = (G * 100 / N);
			int grade = getGrade(P);

			bw.write(grade + " ");

		}

		bw.flush();

	}

	private static int getGrade(int P) {
		if (P >= 0 && P <= 4)
			return 1;
		if (P > 4 && P <= 11)
			return 2;
		if (P > 11 && P <= 23)
			return 3;
		if (P > 23 && P <= 40)
			return 4;
		if (P > 40 && P <= 60)
			return 5;
		if (P > 60 && P <= 77)
			return 6;
		if (P > 77 && P <= 89)
			return 7;
		if (P > 89 && P <= 96)
			return 8;
		if (P > 96 && P <= 100)
			return 9;

		return 0;
	}

}