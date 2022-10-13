import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	
	static class Student{
		int num;
		Set<Integer> like = new HashSet<>();
	}
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int stuCnt = N * N;
		
		Student[] students = new Student[stuCnt];
		Student[] ordered = new Student[stuCnt+1];
		Student stu;
		for(int i = 0; i < stuCnt; ++i) {
			st = new StringTokenizer(br.readLine());
			stu = new Student();
			
			stu.num = Integer.parseInt(st.nextToken());
			for(int j = 0; j < 4; ++j) {
				stu.like.add(Integer.parseInt(st.nextToken()));
			}
			students[i] = stu;
			ordered[stu.num] = stu;
		}
		
		int[][] board = new int[N][N];
		int[] info;
		int want, empty, nx, ny, num;
		for(Student student : students) {
			info = new int[] {-1, 0, 0, 0};
			for(int i = 0; i < N; ++i) {
				for(int j = 0; j < N; ++j) {
					if(board[i][j] != 0) continue;
					want = empty = 0;
					
					for(int d = 0; d < 4; ++d) {
						nx = i + dx[d];
						ny = j + dy[d];
						if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
						
						num = board[nx][ny];
						if(num == 0) ++empty;
						else if(student.like.contains(num)) ++want;
						
					}
					
					if(want > info[0]
							|| (want == info[0] && empty > info[1]) 
							|| (want == info[0] && empty == info[1] && i < info[2])
							|| (want == info[0] && empty == info[1] && i == info[2] && j < info[3])
							) {
						info[0] = want; info[1] = empty; info[2] = i; info[3] = j;
					}
				}
			}
			
			board[info[2]][info[3]] = student.num;
			
		}
		
		int ans = calcScore(ordered, board, N);
		System.out.println(ans);
		
	}

	private static int calcScore(Student[] ordered, int[][] board, int N) {
		int[] score = new int[5];
		
		Student student;
		int want, nx, ny;
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < N; ++j) {
				student = ordered[board[i][j]];
				want = 0;
				for(int d = 0; d < 4; ++d) {
					nx = i + dx[d];
					ny = j + dy[d];
					
					if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
					
					if(student.like.contains(board[nx][ny])) ++want;
				}
				
				++score[want];
			}
		}
		return score[1] * 1 + score[2] * 10 + score[3] * 100 + score[4] * 1000;
	}

}