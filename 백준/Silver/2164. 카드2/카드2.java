import java.io.*;
import java.util.*;


public class Main {
	static int N;
	static Queue<Integer> q ;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		q = new LinkedList<>();
		
		for(int i = 1; i <= N; i++) {
			q.offer(i);
		}
		while(q.size() > 1) {
			q.poll();	// 맨 앞의 원소 버림 
			q.offer(q.poll());	// 맨 앞의 원소를 버림과 동시에 버려진 원소를 맨 뒤에 삽입 
		}
		
		System.out.println(q.poll());	// 마지막으로 남은 원소 출력 

	}

}