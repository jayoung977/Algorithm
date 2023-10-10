import java.io.*;
import java.util.*;
public class Solution {
	static int T,N,M;
	static class Node{
		int s,e;
		public Node(int s, int e) {
			this.s=s;
			this.e=e;
		}
		@Override
		public String toString() {
			return s+","+e;
		}
	}
	static Queue <Node> q;
	static int[] p,r;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T=Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			st=new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken()); 
			M=Integer.parseInt(st.nextToken()); 
			q=new LinkedList<>();
			for(int i=0; i<M; i++) {
				st=new StringTokenizer(br.readLine());
				int s=Integer.parseInt(st.nextToken()); 
				int e=Integer.parseInt(st.nextToken()); 
				q.offer(new Node(s,e));
			}
//			System.out.println(q);
			p=new int[N+1];
			r=new int[N+1];
			
			for(int i=0; i<N+1; i++) {
				p[i]=i;
				r[i]=1;
			}
			while(!q.isEmpty()) {
				Node cur = q.poll();
				union(cur.s, cur.e);
				
			}
			int cnt=0;
			for(int i=1; i<N+1; i++) {
				if(i==p[i]) cnt++;
			}
			
			System.out.println("#"+t+" "+cnt);
		}

	}
	
	static boolean union(int x, int y) {
	    x = find(x);
	    y = find(y);
	    if (x == y) return false;
	    if (r[x] < r[y]) { // cycle없으면 연결함
	      r[y] += r[x];
	      p[x] = y;
	    } else {
	      r[x] += r[y];
	      p[y] = x;
	    }
	    return true;
	  }
	static int find(int x) {
		if(x==p[x]) return p[x];
		else return p[x]=find(p[x]);
	}

}
