import java.util.*;
import java.io.*;
public class Main {
	static int V,R,C;
	static int[][] map;
	static double[][] visited;
	static class Node implements Comparable<Node>{
		int r,c;
		double v,d;
		public Node(int r, int c, double v, double d) {
			this.r=r;
			this.c=c;
			this.v=v;
			this.d=d;
	
		}
		@Override
		public int compareTo(Node o) {
			return Double.compare(this.d,o.d);
		}
	}
	static PriorityQueue<Node> points;
	static final double MM = Double.MAX_VALUE/1000;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V=Integer.parseInt(st.nextToken());
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		
		map=new int[R][C];
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<C; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		visited=new double[R][C];
		for(int i=0; i<R; i++) Arrays.fill(visited[i],MM);
		visited[0][0]=0;
		
		points= new PriorityQueue<>();
		points.offer(new Node(0,0,V,0));
		
		bfs();
		System.out.printf("%.2f",visited[R-1][C-1]);
		

	}
	static int[] dr= {0,1,0,-1};
	static int[] dc= {1,0,-1,0};
	static void bfs() {
		while(!points.isEmpty()) {
			Node cur = points.poll();
			if(visited[cur.r][cur.c]<cur.d) continue;
			for(int d=0; d<4; d++) {
				int nr = cur.r+dr[d];
				int nc = cur.c+dc[d];
				
				if(!(nr>=0 && nc>=0 && nr<R && nc<C)) continue;
				if(visited[nr][nc]>visited[cur.r][cur.c]+(1.0/cur.v)) {
					visited[nr][nc]=visited[cur.r][cur.c]+(1.0/cur.v);
					points.offer(new Node(nr,nc,calV(cur.v,map[cur.r][cur.c],map[nr][nc]),visited[nr][nc]));
				}
			}
		}
	}
	static double calV(double v,int a, int b){
		return v*Math.pow(2, (a-b));
	}
	
	static void print() {
		for(int i=0; i<R; i++) System.out.println(Arrays.toString(visited[i]));
		System.out.println("----------------------------------------");
	}

}