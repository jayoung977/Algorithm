//가장 많이 사용할 예정
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static class NNN {
		int x;
		public NNN(int x) {
			super();
			this.x = x;
		}
		
	}
	static int N;
	static PriorityQueue<NNN> pq;
	public static void main(String[] args) {
		Scanner scann= new Scanner(System.in);
		N=scann.nextInt();
//		pq=new PriorityQueue<>(new Comparator<NNN>() {
//			@Override
//			public int compare(NNN o1, NNN o2) {
//				return Integer.compare(o1.x, o2.x);
//			}
//		});
		pq=new PriorityQueue<>((o1,o2) -> Integer.compare(o2.x ,o1.x));
//		pq=new PriorityQueue<>((o1,o2) -> Integer.compare(o1.x-o2.x));
		for (int i = 0; i < N; i++) {
			int x=scann.nextInt();
			if(x==0) {
				if(pq.size()==0) {
					System.out.println(0);
				}else {
					System.out.println(pq.poll().x);
				}
			}else {
				pq.offer(new NNN(x));
			}
		}
	}

}
