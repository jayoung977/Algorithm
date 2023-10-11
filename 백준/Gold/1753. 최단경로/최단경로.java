import java.io.*;
import java.util.*;
public class Main {
	static int V,E,K;
	static class Node implements Comparable<Node>{
		int v,w;
		public Node(int v, int w){
			this.v=v;
			this.w=w;
		}
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.w, o.w);
		}
	}
	static List<Node>[] adj;
	static PriorityQueue<Node> points;
	static boolean[] visited;
	static int[] distance;
	static int MM = Integer.MAX_VALUE/1000;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		adj = new ArrayList[V+1];
		for(int i=0; i<V+1; i++) adj[i]=new ArrayList<>();
		points=new PriorityQueue<>();
		visited=new boolean[V+1];
		distance = new int[V+1];
		for(int i=0; i<V+1; i++) distance[i]=MM;
		distance[K]=0;
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adj[s].add(new Node(e,w));
		}
		
		points.offer(new Node(K,0));
		while(!points.isEmpty()) {
			Node cur = points.poll();
			if(visited[cur.v]) continue;
			visited[cur.v]=true;
			for(Node next:adj[cur.v]) {
				if(visited[next.v])continue;
				if(distance[next.v]>distance[cur.v]+next.w) {
					distance[next.v]=distance[cur.v]+next.w;
					points.offer(new Node(next.v,distance[next.v]));
				}
			}
		}

		for(int i=1;i<V+1; i++) {
			int d = distance[i];
			if(d==MM) System.out.println("INF");
			else System.out.println(d);
		}
		
		

	}

}