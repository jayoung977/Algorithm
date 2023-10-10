import java.io.*;
import java.util.*;
public class Solution {
	static int T,N,M;
	static int[] p,r;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			p = new int[N+1];
			r = new int[N+1];
			
			for(int i=0; i<N+1; i++) {
				p[i]=i;
				r[i]=1;
			}
			
			
			System.out.print("#"+t+" ");
			
			
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int c = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				if(c==0) {
					union(s,e);
				}else {
					if(find(s)==find(e)) System.out.print(1);
					else System.out.print(0);
				}
			}
			System.out.println();
			
			
		}
		
		
	}
	static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x==y) return false;
		if(r[x]<r[y]) {
			r[y]+=r[x];
			p[x]=y;
		}else {
			r[x]+=r[y];
			p[y]=x;
		}
		return true;
	}
	
	static int find(int x) {
		if(x==p[x]) return p[x];
		else return p[x]=find(p[x]);
	}

}