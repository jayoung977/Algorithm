import java.io.*;
import java.util.*;
public class Solution {
	static int V,E,T;
	static long min;
	static boolean[] visited;
	static class Node implements Comparable<Node>{
		int v,w;
		public Node(int v, int w) {
			this.v=v;
			this.w=w;
		}
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.w, o.w);
		}
	}
	static PriorityQueue<Node> pq;
	static List<Node>[] list;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T=Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			st= new StringTokenizer(br.readLine());
			V=Integer.parseInt(st.nextToken());
			E=Integer.parseInt(st.nextToken());
			min =0L;
			pq = new PriorityQueue<>();
			list = new ArrayList[V+1];
			visited = new boolean[V+1];
			for(int i=0;i<V+1;i++) {
				list[i]=new ArrayList<>();
			}
			for(int i=0; i<E;i++) {
				st= new StringTokenizer(br.readLine());
				int s=Integer.parseInt(st.nextToken());
				int e=Integer.parseInt(st.nextToken());
				int w=Integer.parseInt(st.nextToken());
				list[s].add(new Node(e,w));
				list[e].add(new Node(s,w));
			}
			System.out.println("#"+t+" "+prim());
			
		}
		

	}
	static long prim() {
		pq.offer(new Node(1,0));
		int cnt=0;
		while(!pq.isEmpty()) {
			Node cur=pq.poll();
			if(visited[cur.v]) continue;
			visited[cur.v]=true;
			min+=cur.w;
			if(++cnt==V) return min;
			for(int i=0; i<list[cur.v].size();i++) {
				Node next = list[cur.v].get(i);
				if(visited[next.v]) continue;
				pq.offer(next);
			}
			
		}
		return min;
	}

}