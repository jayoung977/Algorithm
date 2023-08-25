
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int T;
	static int N;
	static int [][] map;
	static double E; 
	
	static class Edge implements Comparable<Edge>{
		int s;
		int e;
		long w;
		public Edge(int s, int e, long w) {
			super();
			this.s = s;
			this.e = e;
			this.w = w;
		}
		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.w, o.w);
		}
	}
	static Edge[] edges;
	static int [] p;
	static int [] r;
	public static void main(String[] args) {
		Scanner scann= new Scanner(System.in);
		T =scann.nextInt();
		for (int t = 1; t <= T; t++) {
			N=scann.nextInt();
			map=new int[N][2];
			for (int i = 0; i < N; i++) {
				map[i][0]=scann.nextInt();
			}
			for (int i = 0; i < N; i++) {
				map[i][1]=scann.nextInt();
			}			
			E =scann.nextDouble();
			edges=new Edge[N*(N-1)/2]; //완전그래프 //pq로 바꿀 수 있음
			int count=0;
			for (int i = 0; i < N-1; i++) {
				for (int j = i+1; j < N; j++) {
					edges[count++]=new Edge(i,j,
							distance(map[i][0],map[j][0],map[i][1],map[j][1])); 
				}
			}
			Arrays.sort(edges); //w작은 순으로 정렬 가능 
			//시작
			p = new int[N];
			r = new int[N];
			makeSet();
			double result=0.0;
			int cnt = 0;
			for (int i = 0; i < (N*(N-1)/2); i++) {
				if(union(edges[i].s,edges[i].e)) {
					result+=edges[i].w;
					cnt++;
					if(cnt==N-1) {
						break;
					}
				}
			}
			System.out.println(String.format("#%d %.0f", t,E*result));
			
		}

	}

	private static boolean union(int x, int y) {
		x=find(x);
		y=find(y);
		if(x==y)return false;
		if(r[x]<r[y]) {
			r[y]+=r[x];
			p[x]=y;
		}else {
			r[x]+=r[y];
			p[y]=x;
		}
		return true;
	}

	private static int find(int x) {
		if(x==p[x])return p[x];
		else return p[x]=find(p[x]);
	}

	private static void makeSet() {
		for (int i = 0; i < N; i++) {
			p[i]=i;
			r[i]=1;
		}
	}
	
	

	private static long distance(int x1,  int x2, int y1,int y2) {
		return 0L+(0L+x1-x2)*(0L+x1-x2)+(0L+y1-y2)*(0L+y1-y2);
	}

}
