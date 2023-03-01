import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	static class Edge {
		int end;
		int weight;

		public Edge(int end, int weight) {
			super();
			this.end = end;
			this.weight = weight;
		}

	}

	static final int INF = 987654321;

	static int[] dist;
	static int N, M, W;
	static int S, E, T;
	static ArrayList<ArrayList<Edge>> graph;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int S, E, T;
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; ++tc) {
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());

			dist = new int[N + 1];
			// 그래프 초기화
			graph = new ArrayList<>();
			for (int i = 0; i <= N; ++i) {
				graph.add(new ArrayList<>());
			}

			// 그래프 정보 입력
			for (int i = 0; i < M; ++i) {
				st = new StringTokenizer(br.readLine());

				S = Integer.parseInt(st.nextToken());
				E = Integer.parseInt(st.nextToken());
				T = Integer.parseInt(st.nextToken());

				graph.get(S).add(new Edge(E, T));
				graph.get(E).add(new Edge(S, T));

			}

			// 웜홀 정보 입력
			for (int i = 0; i < W; ++i) {
				st = new StringTokenizer(br.readLine());

				S = Integer.parseInt(st.nextToken());
				E = Integer.parseInt(st.nextToken());
				T = Integer.parseInt(st.nextToken());

				graph.get(S).add(new Edge(E, -T));

			}
			
			sb.append(ballmanFord() ? "YES" : "NO").append("\n");

		}

		bw.write(sb.toString());
		bw.flush();

		bw.close();
		br.close();

	}

	private static boolean ballmanFord() {
		Arrays.fill(dist, INF);
		dist[1] = 0;
		boolean update = false;
		
		for(int i = 1; i < N; ++i) {
			update = false;
			
			for(int j = 1; j <= N; j++) {
				for(Edge edge : graph.get(j)) {
					if(dist[edge.end] > dist[j] + edge.weight) {
						dist[edge.end] = dist[j] + edge.weight;
						update = true;
					}
				}
			}
			
			if(!update) break;
		}
		
		if(update) {
			for(int i = 1; i <= N; ++i) {
				for(Edge edge : graph.get(i)) {
					if(dist[edge.end] > dist[i] + edge.weight) {
						return true;
					}
				}
			}
		}
		
		return false;
	}

}