import java.util.*;
import java.io.*;
public class Main {
	
	static class Edge implements Comparable<Edge>{
		int s;
		int e;
		int w;
		
		public Edge(int s, int e, int w) {
			this.s=s;
			this.e=e;
			this.w=w;
		}
		@Override
		public int compareTo(Edge o) {
			return this.w-o.w;
		}

		
	}
	static int V,E;
	static long min;
	static PriorityQueue<Edge> pq;
	static int[] p,r;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		pq = new PriorityQueue<>();
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			pq.offer(new Edge(s,e,w));
		}
		p = new int[V+1];
		r = new int[V+1];
		makeSet();
		int cnt =0;
		min = 0;
		while(cnt<V-1) {
			Edge edge = pq.poll();
			if(union(edge.s, edge.e)) {
				cnt++;
				min+=edge.w;
			}
		}
		System.out.println(min);
	}
	static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x==y) return false;
		if(r[x]>r[y]) {
			r[x]+=r[y];
			p[y]=x;
		}else {
			r[y]+=r[x];
			p[x]=y;
		}
		return true;
	}
	
	static int find(int x) {
		if(x==p[x]) return p[x];
		return p[x]= find(p[x]);
	}
	
	static void makeSet() {
		for(int i=0; i<V+1; i++) {
			p[i]=i;
			r[i]=1;
		}
	} 

}
