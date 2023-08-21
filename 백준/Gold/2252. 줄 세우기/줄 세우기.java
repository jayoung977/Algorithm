import java.io.*;
import java.util.*;
public class Main {
	static int N,M;
	static List<Integer>[] list;
	static int [] indegree;
	public static void main(String[] args) {
		Scanner scann= new Scanner(System.in);
		N=scann.nextInt();
		M=scann.nextInt();
		indegree= new int[N+1];
		//adjlist 생성
		list=new ArrayList[N+1];
		for (int i = 0; i < N+1; i++) {
				list[i]= new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			int from=scann.nextInt();
			int to=scann.nextInt(); //한방향
			list[from].add(to); //유향임 주의
			//to: 진입
			indegree[to]++; //진입 차수 0으로 만들 예정 /세로 방향?
		}
		tp(indegree,list);
//		System.out.println();
	}
	static void tp(int[] indegree2, List<Integer>[] list2) {
		PriorityQueue<Integer> pq =new PriorityQueue<>();
		//진입 차수가 0인 노드를 큐에 모두 넣는다. 
		//0에 해당되는 곳에서 연결된 인접리스트의 수를 -1
		for (int i = 1; i < indegree2.length; i++) {//1부터
			if(indegree2[i]==0) {//진입 차수 0이니
				pq.offer(i);
			}
		}
		while(!pq.isEmpty()) {//진입차수 끝났냐? 다 돌때까지 
			int indegreeZero=pq.poll();
			List<Integer> vertexs=list2[indegreeZero];
			for (int i = 0; i < vertexs.size(); i++) { //DAG아니면 size가 남아있게 됨 
				int no=vertexs.get(i);
				indegree2[no]--;// 연결된거 하나뺌
				if(indegree2[no]==0) {//새로운 진입지점 0, 진입 차수 0이니
					pq.offer(no);
				}
			}
			System.out.print(indegreeZero+" ");
		}
	}
	

}
