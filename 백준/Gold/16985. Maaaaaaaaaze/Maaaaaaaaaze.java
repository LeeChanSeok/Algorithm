import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	
	public static class Maze {
		final int N = 5;
		char[][][] maze;

		public Maze(char[][][] maze) {
			super();
			this.maze = maze;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + N;
			result = prime * result + Arrays.deepHashCode(maze);
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			Maze other = (Maze) obj;
			
			for(int k = 0; k < N; ++k) {
				for(int i = 0; i < N; ++i) {
					for(int j = 0; j < N; ++j) {
						if(maze[k][i][j] != other.maze[k][i][j]) return false; 
					}
				}
			}

			return true;
		}
		
	}

	static final int[] dx = {-1, 1, 0, 0, 0, 0};
	static final int[] dy = {0, 0, -1, 1, 0, 0};
	static final int[] dz = {0, 0, 0, 0, -1, 1};
	
	static final int N = 5;
	static final int INF = Integer.MAX_VALUE;
	static int min;
	static char[][][] maze;
	static int[] permArr;
	static final int[][][] ent_exit = {
			{{0, 0, 0},{4 ,4, 4}},
			{{0, 0, 4},{4, 4, 0}},
			{{0, 4, 0},{4, 0, 4}},
			{{0, 4, 4},{4, 0, 0}}
			};

	static Set<Maze> mazes;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		maze = new char[N][N][N];
		
		for(int k = 0; k < N; ++k) {
			for(int i = 0; i < N; ++i) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; ++j) {
					maze[k][i][j] = st.nextToken().charAt(0);
				}
			}
		}
		
		mazes = new HashSet<>();
		permArr = new int[N];
		min = INF;
		recursive(0);
		
		if(min == INF) min = -1;
		System.out.println(min);
		
	}
	
	private static void recursive(int level) {
		
		if(N == level) {
			char[][][] newMaze;
			Maze temp;
			initArr(permArr);
			do {
				newMaze = makeMaze(maze, permArr);
				temp = new Maze(newMaze);
				if(mazes.contains(temp)) continue;
				mazes.add(temp);
				exit_maze(newMaze);
			}while(next_Permutation(permArr));
			return;
		}
		
		for(int d = 0; d < 4; ++d) {
			recursive(level+1);
			rotate(maze[level]);
		}
		
	}
	
	private static void exit_maze(char[][][] maze) {
		
		int[] from, to;
		for(int d = 0; d < 4; ++d) {
			from = ent_exit[0][0];
			to = ent_exit[0][1];
			if(isGo(from, maze) && isGo(to, maze)) {
				min = Math.min(min, bfs(from, to, maze));
			}
		}
	}
	
	private static boolean isGo(int[] pos, char[][][] maze) {
		if(maze[pos[0]][pos[1]][pos[2]] == '0') return false;
		return true;
	}

	private static int bfs(int[] from, int[] to, char[][][] maze) {
		
		Queue<int[]> q = new LinkedList<>();
		q.offer(from);
		
		boolean[][][] visit = new boolean[N][N][N];
		visit[from[0]][from[1]][from[2]] = true;
		
		int cnt = 0;
		int x, y, z, nx, ny, nz;
		int qSize;
		int[] cur;
		while(!q.isEmpty()) {
			
			qSize = q.size();
			while(qSize-- > 0) {
				cur = q.poll();
				x = cur[1]; y = cur[2]; z = cur[0];
				
				if(x == to[1] && y == to[2] && z == to[0]) return cnt;
				
				for(int d = 0; d < 6; ++d) {
					nx = x + dx[d];
					ny = y + dy[d];
					nz = z + dz[d];
					
					if(!inRange(nx, ny, nz) || visit[nz][nx][ny] || maze[nz][nx][ny] == '0') continue;
					
					q.offer(new int[] {nz, nx, ny});
					visit[nz][nx][ny] = true;
				}
				
			}
			
			++cnt;
		}
		
		return INF;
		
	}

	private static boolean inRange(int x, int y, int z) {
		if(x < 0 || x >= N || y < 0 || y >= N || z < 0 || z >= N) return false;
		return true;
	}

	private static void initArr(int[] permArr1) {
		for(int i = 0; i < N; ++i) permArr[i] = i;
	}

	private static char[][][] makeMaze(char[][][] maze, int[] permArr) {
		char[][][] newMaze = new char[N][N][N];
		
		for(int i = 0; i < N; ++i) {
			arrayCopy(maze[permArr[i]], newMaze[i]);
		}
		return newMaze;
	}

	public static void rotate(char[][] array) {
		
		char[][] temp = new char[N][N];
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < N; ++j) {
				temp[i][j] = array[N-1-j][i];
			}
		}
		arrayCopy(temp, array);
	}

	public static void arrayCopy(char[][] from, char[][] to) {
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < N; ++j)
				to[i][j] = from[i][j];
		}
	}
	
	public static boolean next_Permutation(int[] arr) {
			int i = N -1;
			while(i > 0 && arr[i - 1] > arr[i]) --i;
			
			if(i == 0) return false;
			
			int j = N-1;
			while( arr[i-1] >= arr[j]) --j;
			
			swap(i-1, j);
			
			int k = N-1;
			while(i < k) {
				swap(i, k);
				++i; --k;
			}
			
			return true;
	}
	
	public static void swap(int i, int j) {
		int temp = permArr[i];
		permArr[i] = permArr[j];
		permArr[j] = temp;
	}
}