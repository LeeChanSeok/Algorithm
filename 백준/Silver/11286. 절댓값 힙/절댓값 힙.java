import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Number implements Comparable<Number>{
	int value;
	int abs;

	public Number(int value, int abs) {
		this.value = value;
		this.abs = abs;
	}

	@Override
	public int compareTo(Number o) {
		if(this.abs == o.abs)
			return this.value < o.value ? -1: 1;
		else
			return this.abs < o.abs ? -1 : 1;
	}
}

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Number> absHeap = new PriorityQueue<>();
		int v;
		for (int n = 0; n < N; n++) {
			v = Integer.parseInt(br.readLine());
			if (v != 0) absHeap.add(new Number(v, Math.abs(v)));
			else {
				if(absHeap.size() == 0) System.out.println(0);
				else System.out.println(absHeap.poll().value);
			}
		}
	}
}