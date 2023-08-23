import java.io.*;
import java.util.*;
public class Main {
	static int N;
	static double min;
	static double[][] map;
	static double MM=0.0f+Integer.MAX_VALUE;
	static PriorityQueue<Edg> points;
	static class Edg implements Comparable<Edg>{
		int s;
		int e;
		double w;
		
		public Edg(int p1, int p2, double weight) {
			super();
			this.s = p1;
			this.e = p2;
			this.w = weight;
		}

		@Override
		public int compareTo(Edg o) {
			return Double.compare(this.w, o.w);
		}
	}
	
	public static double distance(int s,int e) {
		double x=(map[s][0]-map[e][0]);
		double y=(map[s][1]-map[e][1]);
		return Math.sqrt(x*x+y*y);
		
	}
	static int[] p;
	static int[] r;
	static double result;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new double [N][2];
		
		for (int i = 0; i < N; i++) {
			st =new StringTokenizer(br.readLine());
			map[i][0] = Double.parseDouble(st.nextToken());
			map[i][1] = Double.parseDouble(st.nextToken());
		}
		points = new PriorityQueue<>();
		//조합
		for (int i = 0; i < N; i++) {
			for (int j = i+1; j < N; j++) {
				points.offer(new Edg(i, j, distance(i,j)));
			}
		}
		p = new int[N+1];
		r = new int[N+1];
		makeSet();
		int cnt=0;
		result=0;
		while (cnt != N - 1) {
		      Edg edge = points.poll();
		      if (union(edge.s, edge.e)) { // 부모 같냐
		        cnt++;
		        result += edge.w;
		      }
		    }
		    System.out.println(String.format("%.2f", result));

			
		}
	private static boolean union(int x, int y) {
	    x = find(x);
	    y = find(y);
	    if (x == y) // 부모 같으면 cycle발생하므로 더 안돌게 false 반환
	      return false;
	    if (r[x] < r[y]) { // cycle없으면 연결함
	      r[y] += r[x];
	      p[x] = y;
	    } else {
	      r[x] += r[y];
	      p[y] = x;
	    }
	    return true;
	  }

	  private static int find(int x) {
	    if (x == p[x])
	      return p[x];
	    else
	      return p[x] = find(p[x]);
	  }

	  private static void makeSet() {
	    for (int i = 0; i < N + 1; i++) {
	      p[i] = i;
	    }
	    for (int i = 0; i < N + 1; i++) {
	      r[i] = 1;
	    }

	  }


}
