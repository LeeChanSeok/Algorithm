import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static long B;
	static final int DIV = 1000;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		B = Long.parseLong(st.nextToken());
		
		int[][] answer = new int[N][N];
		int[][] matrix = new int[N][N];
		
		for(int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; ++j) {
				matrix[i][j] = Integer.parseInt(st.nextToken())%DIV;
			}
		}
		
		answer = calc(matrix, B);
		
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < N; ++j) {
				sb.append(answer[i][j] + " ");
			}
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		
		bw.close();
		br.close();
		
	}
	
	private static int[][] calc(int[][] matrix, long b) {
		if(b == 1) {
			return matrix;
		}
		
		int[][] res = new int[N][N];
		if((b&1) == 0) {
			res = calc(matrix, b/2);
			res = matrix_Multifly(res, res); 
		}else{
			res = calc(matrix, b/2);
			res = matrix_Multifly(res, res); 
			res = matrix_Multifly(res, matrix);
		}
		
		return res;
	}

	public static int[][] matrix_Multifly(int[][] A, int[][] B) {
		
		int[][] res = new int[N][N];
		
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < N; ++j) {
				for(int k = 0; k < N; ++k) {
					res[i][j] += A[i][k] * B[k][j];
				}
				res[i][j] %= DIV;
			}
		}
		
		return res;
	}

}
