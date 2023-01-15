import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	
	static public class Perm{
		int[] nums;

		public Perm(int[] nums) {
			super();
			this.nums = nums.clone();
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + Arrays.hashCode(nums);
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Perm other = (Perm) obj;
			if (!Arrays.equals(nums, other.nums))
				return false;
			return true;
		}
		
	}
	
	static int[] numbers;
	static Set<Perm> set;
	static int[] perm;
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		numbers = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; ++i) numbers[i] = Integer.parseInt(st.nextToken());
		
		set = new HashSet<>();
		perm = new int[M];
		permutation(0, 0);
		
		List<Perm> list = new ArrayList<>(set);
		list.sort((l1, l2) -> {
			for(int i = 0; i < M; ++i) {
				if(l1.nums[i] == l2.nums[i]) continue;
				return l1.nums[i] - l2.nums[i];
			}
			return 0;
		});
		
		for(Perm p : list) {
			for(int n : p.nums) System.out.print(n + " ");
			System.out.println();
		}
		
		
	}
	private static void permutation(int idx, int flag) {
		
		if(idx == M) {
			set.add(new Perm(perm));
			return;
		}
		
		for(int i = 0; i < N; ++i) {
			if((flag & (1 << i)) !=0 ) continue;
			perm[idx] = numbers[i];
			permutation(idx+1, flag | 1 << i);
		}
		
		
	}

}