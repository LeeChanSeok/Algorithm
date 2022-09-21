import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static class Word implements Comparable<Word>{
		String word;
		int count;
		int length;
		
		public Word(String word) {
			super();
			this.word = word;
			length = word.length();
		}

		@Override
		public int compareTo(Word o) {

			if(this.count == o.count) {
				if(this.length == o.length) return this.word.compareTo(o.word);
				return o.length - this.length;
			}
			return o.count - this.count;
		}
		
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<String, Word> wordMap = new HashMap<>();
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			if(str.length() < M) continue;
			
			if(wordMap.containsKey(str)) wordMap.get(str).count++;
			else {
				Word word = new Word(str);
				wordMap.put(str, word);
			}
		}
		
		PriorityQueue<Word> pq = new PriorityQueue<>();
		for(String key : wordMap.keySet()) {
			pq.offer(wordMap.get(key));
		}
		
		while(!pq.isEmpty())
			sb.append(pq.poll().word).append("\n");
		
		bw.write(sb.toString());
		bw.close();

	}

}