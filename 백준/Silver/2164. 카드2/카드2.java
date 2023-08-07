import java.io.*;
import java.util.*;


public class Main {
	static int N;
	static Deque<Integer> deque ;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		deque = new ArrayDeque<>();
		
		for(int i = 1; i <= N; i++) {
			deque.addLast(i);
		}
		while(deque.size() > 1) {
			deque.pollFirst();	// 맨 앞의 원소 버림 
			deque.addLast(deque.pollFirst());	// 맨 앞의 원소를 버림과 동시에 버려진 원소를 맨 뒤에 삽입 
		}
		
		System.out.println(deque.pollFirst());	// 마지막으로 남은 원소 출력 

	}

}