import java.util.*;
import java.io.*;
public class Main {
	 static int N;
	 static List<Integer>[] adj;
	 static boolean[] isCycle;
	 static class Node{
		 int v;
		 int d;
		 Node(int v, int d){
			 this.v=v;
			 this.d=d;
		 }
	 }
	 static Queue<Node> q;
	 static boolean[] visited;
	 public static void main(String[] args) throws Exception{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st;
		 N = Integer.parseInt(br.readLine());
		 adj = new ArrayList[N+1];
		 for(int i=0; i<N+1; i++) adj[i]=new ArrayList<>();
		 for(int i=0; i<N; i++) {
			 st = new StringTokenizer(br.readLine());
			 int s = Integer.parseInt(st.nextToken()); 
			 int e = Integer.parseInt(st.nextToken()); 
			 adj[s].add(e);
			 adj[e].add(s);
		 }
		 isCycle = new boolean[N+1];
		 for(int i=1; i<N+1; i++) {
			 if(checkCycle_dfs(i,i,i)) break;
			 isCycle = new boolean[N+1];
		 }
//		 System.out.println(Arrays.toString(isCycle));
		 
		 StringBuilder sb= new StringBuilder();
		 for(int i=1; i<N+1; i++) {	  
			 sb.append(bfs(i)).append(" ");		
		 }
		 System.out.println(sb.toString());

	} 
	static boolean checkCycle_dfs(int prev, int cur, int start) {
		isCycle[cur]=true;
		for(int i=0; i<adj[cur].size(); i++) {
			int next = adj[cur].get(i);
			if(!isCycle[next]) { // F
				if(checkCycle_dfs(cur,next,start)) return true;
			}else if(prev!=next && next==start ) {// T 
				return true;
			}
		}
		isCycle[cur]=false;
		
		return false;
	}
	
	static int bfs(int v) {
		if(isCycle[v]) return 0;
		q = new LinkedList<>();
		visited = new boolean[N+1];
		q.offer(new Node(v,0));
		visited[v]=true;
		while(!q.isEmpty()) {
			Node cur = q.poll();
			if(isCycle[cur.v]) return cur.d;
			for(int i=0; i<adj[cur.v].size(); i++) {
				int next = adj[cur.v].get(i);
				if(!visited[next]) {
					visited[next]=true;
					q.offer(new Node(next,cur.d+1));
				}
			}
		}
		
		return 0;
	}
	
}