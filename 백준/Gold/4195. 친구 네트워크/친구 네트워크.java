import java.util.*;
import java.io.*;
public class Main {
	static int T,F;
	static HashMap<String, Integer> map;
	static class Node {
		int s,e;
		public Node(int s, int e){
			this.s=s;
			this.e=e;
		}
	}
	static int[] p,r;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			F = Integer.parseInt(br.readLine());
			map = new HashMap<>();
			int cnt=0;
			p = new int[200001];
			r = new int[200001];
			
			for(int i=0; i<p.length; i++) {
				p[i]=i;
				r[i]=1;
			}
			
			for(int i=0; i<F; i++) {
				st = new StringTokenizer(br.readLine());
				String s = st.nextToken();
				String e = st.nextToken();
				if(map.get(s) == null) map.put(s,++cnt); 
				if(map.get(e) == null) map.put(e,++cnt); 
				union(map.get(s).intValue(),map.get(e).intValue());	
				int answer = r[find(map.get(s).intValue())];
				System.out.println(answer);
//				map.putIfAbsent(e,++cnt); 
			}
//			System.out.println(map);
			
		}

	}
	static boolean union(int x, int y) {
		x=find(x);
		y=find(y);
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
		return p[x]=find(p[x]);
	}

}