import java.io.*;
import java.util.*;
public class Main {

	static class Edge implements Comparable<Edge>{
		int v;
		int w;
		public Edge(int v, int w) {
			super();
			this.v = v;
			this.w = w;
		}
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.w, o.w);
		};
	}
	//무한대로 하고 시작점을 0으로 바꾸는게 아이디어 <->프림은 걍 암거나
	static int V,E,K;
	static int [] distance;
	static boolean [] visited;
	static List<Edge>[] adj;
	static int MM=Integer.MAX_VALUE/1000;
	static PriorityQueue<Edge> points;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V=Integer.parseInt(st.nextToken());
		E=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(br.readLine());
		adj=new ArrayList[V];
		for (int i = 0; i < V; i++) {
			adj[i]=new ArrayList<>();
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int s=Integer.parseInt(st.nextToken());
			int e=Integer.parseInt(st.nextToken());
			int w=Integer.parseInt(st.nextToken());
			adj[s-1].add(new Edge(e-1,w)); //0부터라 -1함//양방향인지 확인
		}
		distance=new int[V];
		Arrays.fill(distance, MM);
		visited=new boolean[V];
		points=new PriorityQueue<>();
		points.offer(new Edge(K-1,0));
		distance[K-1]=0;
		while(!points.isEmpty()) {
			Edge cur=points.poll();
			if(visited[cur.v]) continue;
			visited[cur.v]=true;
			for (Edge next:adj[cur.v]) {
				if(visited[next.v]) continue;
				//이부분만 프림과 다름/////////////////////
				if(distance[next.v]>distance[cur.v]+next.w) { 
					distance[next.v]=distance[cur.v]+next.w;
					points.offer(new Edge(next.v,distance[next.v]));//업데이트
					
				}
				//////////////////////////////////////
				
			}
		}
		//K -> i
		for (int i = 0; i < V; i++) {
			if(distance[i]>=MM) {
				System.out.println("INF");
			}else {
				System.out.println(distance[i]);//최단거리
			}
		}
	}
}
