
import java.util.*;
import java.io.*;
public class Solution {
	static int T,V;
	static double E;
	static double min;
	static class Node implements Comparable<Node>{
		int v;
		double w;
		public Node(int v, double w) {
			this.v=v;
			this.w=w;
		}
		@Override
		public int compareTo(Node o) {
			return Double.compare(this.w, o.w);
		}
	}
	static List<Node>[] list;
	static PriorityQueue<Node> pq;
	static boolean[] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T=Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			V=Integer.parseInt(br.readLine());			
			int[][] arr = new int[V+1][2];
			//X
			st=new StringTokenizer(br.readLine());
			for(int i=1; i<V+1; i++) {
				arr[i][0]=Integer.parseInt(st.nextToken());
			}
			//Y
			st=new StringTokenizer(br.readLine());
			for(int i=1; i<V+1; i++) {
				arr[i][1]=Integer.parseInt(st.nextToken());
			}
			E=Double.parseDouble(br.readLine());
			min=0;
			list = new ArrayList[V+1];
			for(int i=0;i<V+1;i++) {
				list[i]=new ArrayList<>();
			}
			
			for(int i=1;i<V+1;i++) {
				for(int j=i+1;j<V+1;j++) {
//					System.out.println(i+","+j);
					double w = Math.pow(Math.abs(arr[i][0]-arr[j][0]),2)+Math.pow(Math.abs(arr[i][1]-arr[j][1]),2);
					w = E*w;
					list[i].add(new Node(j,w));
					list[j].add(new Node(i,w));
				}
			}
	
			pq = new PriorityQueue<>();
			visited=new boolean[V+1];
			System.out.println("#"+t+" "+prim());
		}
	

	}
	static long prim() {
		pq.offer(new Node(1,0));
		int cnt=0;
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			if(visited[cur.v]) continue;
			visited[cur.v]=true;
			min+=cur.w;
			if(++cnt==V) return Math.round(min);
			for(int i=0; i<list[cur.v].size();i++) {
				Node next = list[cur.v].get(i);
				if(visited[next.v]) continue;
				pq.offer(next);
			}
			
		}
		
		
		
		return  Math.round(min);
	}

}
