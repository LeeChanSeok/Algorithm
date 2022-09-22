import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Student implements Comparable<Student>{
		String name;
		int kor, eng, math;
		
		public Student(String name, int kor, int eng, int math) {
			super();
			this.name = name;
			this.kor = kor;
			this.eng = eng;
			this.math = math;
		}
		
		@Override
		public int compareTo(Student o) {

			if(this.kor == o.kor) {
				if(this.eng == o.eng) {
					if(this.math == o.math) return this.name.compareTo(o.name);
					return o.math - this.math;
				}
				return this.eng - o.eng;
			}
			return o.kor - this.kor;
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Student> pq = new PriorityQueue<>(N);
		String name;
		int kor, eng, math;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			name = st.nextToken();
			kor = Integer.parseInt(st.nextToken());
			eng = Integer.parseInt(st.nextToken());
			math = Integer.parseInt(st.nextToken());
			
			pq.offer(new Student(name, kor, eng, math));
		}

		while(!pq.isEmpty()) {
			sb.append(pq.poll().name + "\n");
		}
		
		bw.write(sb.toString());
		bw.close();
		
	}

}