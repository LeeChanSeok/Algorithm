import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	static class Node{
		char c;
		Node prev, next;
		
		public Node(char c, Node prev, Node next) {
			super();
			this.c = c;
			this.prev = prev;
			this.next = next;
		}
		
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		
		int strLen = str.length();
		Node head = new Node('\0', null, null);
		Node node = head;
		for(int i = 0; i < strLen; ++i) {
			
			Node temp = new Node(str.charAt(i), node, null);
			node.next = temp;
			node = temp;
		}
		
		int N = Integer.parseInt(br.readLine());
		String[] command;
		for(int i = 0; i < N; ++i) {
			command = br.readLine().split(" ");
			if(command[0].equals("L")) {
				if(node.prev != null) node = node.prev;
			}else if(command[0].equals("D")) {
				if(node.next != null) node = node.next;
			}else if(command[0].equals("B")) {
				if(node != head) {
					node.prev.next = node.next;
					if(node.next != null) node.next.prev = node.prev;
					node = node.prev;
									}
			}else if(command[0].equals("P")) {
				Node temp = new Node(command[1].charAt(0), null, null);
				if(node.next == null) {
					node.next = temp;
					temp.prev = node;
				}else {
					temp.next = node.next;
					temp.prev = node;
					
					node.next.prev = temp;
					node.next = temp;
				}
				node = node.next;
			}
		}
		
		node = head.next;
		while(node != null) {
			sb.append(node.c);
			node = node.next;
		}
		
		bw.write(sb.toString());
		bw.close();

	}

}