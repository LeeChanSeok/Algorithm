import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static class Station {
		double dist;
		int e, s;

		public Station(double dist) {
			super();
			this.dist = dist;

		}

	}

	static int MAX_N = 43;
	static Map<String, Integer> name2idx;
	static Station[] stations;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		initailize();

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());

			String name = st.nextToken();
			String[] e = st.nextToken().split(":");
			String[] s = st.nextToken().split(":");

			if (!e[0].equals("-"))
				stations[name2idx.get(name)].e = Integer.parseInt(e[0]) * 60 + Integer.parseInt(e[1]);
			if (!s[0].equals("-"))
				stations[name2idx.get(name)].s = Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
		}

		for (int i = 0; i < Q; ++i) {
			st = new StringTokenizer(br.readLine());
			Station start = stations[name2idx.get(st.nextToken())];
			Station end = stations[name2idx.get(st.nextToken())];

			double dist = Math.abs(end.dist - start.dist);
			int time = 0;
			if (end.e < start.s) {
				time = 60 * 24 - start.s + end.e;
			} else {
				time = end.e - start.s;
			}

			System.out.printf("%.8f\n", dist / time * 60);
		}

	}

	private static void initailize() {
		name2idx = new HashMap<>();
		name2idx.put("Seoul", 1);
		name2idx.put("Yeongdeungpo", 2);
		name2idx.put("Anyang", 3);
		name2idx.put("Suwon", 4);
		name2idx.put("Osan", 5);
		name2idx.put("Seojeongri", 6);
		name2idx.put("Pyeongtaek", 7);
		name2idx.put("Seonghwan", 8);
		name2idx.put("Cheonan", 9);
		name2idx.put("Sojeongni", 10);

		name2idx.put("Jeonui", 11);
		name2idx.put("Jochiwon", 12);
		name2idx.put("Bugang", 13);
		name2idx.put("Sintanjin", 14);
		name2idx.put("Daejeon", 15);
		name2idx.put("Okcheon", 16);
		name2idx.put("Iwon", 17);
		name2idx.put("Jitan", 18);
		name2idx.put("Simcheon", 19);
		name2idx.put("Gakgye", 20);

		name2idx.put("Yeongdong", 21);
		name2idx.put("Hwanggan", 22);
		name2idx.put("Chupungnyeong", 23);
		name2idx.put("Gimcheon", 24);
		name2idx.put("Gumi", 25);
		name2idx.put("Sagok", 26);
		name2idx.put("Yangmok", 27);
		name2idx.put("Waegwan", 28);
		name2idx.put("Sindong", 29);
		name2idx.put("Daegu", 30);

		name2idx.put("Dongdaegu", 31);
		name2idx.put("Gyeongsan", 32);
		name2idx.put("Namseonghyeon", 33);
		name2idx.put("Cheongdo", 34);
		name2idx.put("Sangdong", 35);
		name2idx.put("Miryang", 36);
		name2idx.put("Samnangjin", 37);
		name2idx.put("Wondong", 38);
		name2idx.put("Mulgeum", 39);
		name2idx.put("Hwamyeong", 40);

		name2idx.put("Gupo", 41);
		name2idx.put("Sasang", 42);
		name2idx.put("Busan", 43);

		stations = new Station[MAX_N + 1];
		stations[1] = new Station(0.0);
		stations[2] = new Station(9.1);
		stations[3] = new Station(23.9);
		stations[4] = new Station(41.5);
		stations[5] = new Station(56.5);
		stations[6] = new Station(66.5);
		stations[7] = new Station(75.0);
		stations[8] = new Station(84.4);
		stations[9] = new Station(96.6);
		stations[10] = new Station(107.4);

		stations[11] = new Station(114.9);
		stations[12] = new Station(129.3);
		stations[13] = new Station(139.8);
		stations[14] = new Station(151.9);
		stations[15] = new Station(166.3);
		stations[16] = new Station(182.5);
		stations[17] = new Station(190.8);
		stations[18] = new Station(196.4);
		stations[19] = new Station(200.8);
		stations[20] = new Station(204.6);

		stations[21] = new Station(211.6);
		stations[22] = new Station(226.2);
		stations[23] = new Station(234.7);
		stations[24] = new Station(253.8);
		stations[25] = new Station(276.7);
		stations[26] = new Station(281.3);
		stations[27] = new Station(289.5);
		stations[28] = new Station(296.0);
		stations[29] = new Station(305.9);
		stations[30] = new Station(323.1);

		stations[31] = new Station(326.3);
		stations[32] = new Station(338.6);
		stations[33] = new Station(353.1);
		stations[34] = new Station(361.8);
		stations[35] = new Station(372.2);
		stations[36] = new Station(381.6);
		stations[37] = new Station(394.1);
		stations[38] = new Station(403.2);
		stations[39] = new Station(412.4);
		stations[40] = new Station(421.8);

		stations[41] = new Station(425.2);
		stations[42] = new Station(430.3);
		stations[43] = new Station(441.7);
	}

}